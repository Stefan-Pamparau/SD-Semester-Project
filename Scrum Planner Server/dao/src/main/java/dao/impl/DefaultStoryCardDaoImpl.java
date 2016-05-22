package dao.impl;

import org.hibernate.SessionFactory;

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
    public StoryCard getStoryCard(Integer id) throws DaoException {
        return null;
    }

    @Override
    public void insertStoryCard(StoryCard storyCard) throws DaoException {

    }

    @Override
    public void updateStoryCard(StoryCard storyCard) throws DaoException {

    }

    @Override
    public void deleteStoryCard(StoryCard storyCard) throws DaoException {

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
