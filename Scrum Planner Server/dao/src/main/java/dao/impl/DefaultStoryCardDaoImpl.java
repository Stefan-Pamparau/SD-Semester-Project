package dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import dao.StoryCardDao;
import dao.exception.DaoException;
import model.planner.card.StoryCard;

/**
 * Default implementation of the StoryCardDao interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultStoryCardDaoImpl implements StoryCardDao {
    private SessionFactory sessionFactory;

    public DefaultStoryCardDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public StoryCard getStoryCard(Integer id) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            return session.get(StoryCard.class, id);
        } catch (HibernateException e) {
            throw new DaoException("Cannot retrieve story card with id:" + id, e);
        }
    }

    @Override
    @Transactional
    public void insertStoryCard(StoryCard storyCard) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            session.save(storyCard);
            session.flush();
        } catch (HibernateException e) {
            throw new DaoException("Cannot insert story card", e);
        }
    }

    @Override
    @Transactional
    public void updateStoryCard(StoryCard storyCard) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            StoryCard persistentStoryCard = session.get(StoryCard.class, storyCard.getId());

            if (persistentStoryCard != null) {
                persistentStoryCard.setStoryPoints(storyCard.getStoryPoints());
                persistentStoryCard.setTitle(storyCard.getTitle());
                persistentStoryCard.setDescription(storyCard.getDescription());
                session.update(persistentStoryCard);
                session.flush();
            }
        } catch (HibernateException e) {
            throw new DaoException("Cannot update story card", e);
        }
    }

    @Override
    @Transactional
    public void deleteStoryCard(StoryCard storyCard) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            StoryCard persistentStoryCard = session.get(StoryCard.class, storyCard.getId());

            if (persistentStoryCard != null) {
                session.delete(persistentStoryCard);
                session.flush();
            }
        } catch (HibernateException e) {
            throw new DaoException("Cannot delete story card", e);
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
