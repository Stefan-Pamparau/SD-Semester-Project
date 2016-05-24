package dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import dao.StoryPanelDao;
import dao.exception.DaoException;
import model.planner.taskboard.StoryPanel;

/**
 * Default implementation od the StoryPanelDao interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultStoryPanelDaoImpl implements StoryPanelDao {
    private SessionFactory sessionFactory;

    public DefaultStoryPanelDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public StoryPanel getStoryPanel(Integer id) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            return session.get(StoryPanel.class, id);
        } catch (HibernateException e) {
            throw new DaoException("Cannot retrieve story panel with id:" + id, e);
        }
    }

    @Override
    @Transactional
    public void insertStoryPanel(StoryPanel storyPanel) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            session.save(storyPanel);
        } catch (HibernateException e) {
            throw new DaoException("Cannot insert story panel", e);
        }
    }

    @Override
    @Transactional
    public void updateStoryPanel(StoryPanel storyPanel) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            StoryPanel persistentStoryPanel = session.get(StoryPanel.class, storyPanel.getId());

            if (persistentStoryPanel != null) {
                persistentStoryPanel.setStoryCards(storyPanel.getStoryCards());
                session.update(persistentStoryPanel);
            }
        } catch (HibernateException e) {
            throw new DaoException("Cannot update story panel", e);
        }
    }

    @Override
    @Transactional
    public void deleteStoryPanel(StoryPanel storyPanel) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            StoryPanel persistentStoryPanel = session.get(StoryPanel.class, storyPanel.getId());

            if (persistentStoryPanel != null) {
                session.update(persistentStoryPanel);
            }
        } catch (HibernateException e) {
            throw new DaoException("Cannot delete story panel", e);
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
