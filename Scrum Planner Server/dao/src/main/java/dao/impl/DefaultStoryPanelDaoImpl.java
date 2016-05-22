package dao.impl;

import org.hibernate.SessionFactory;

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
    public StoryPanel getStoryPanel(Integer id) throws DaoException {
        return null;
    }

    @Override
    public void insertStoryPanel(StoryPanel storyPanel) throws DaoException {

    }

    @Override
    public void updateStoryPanel(StoryPanel storyPanel) throws DaoException {

    }

    @Override
    public void deleteStoryPanel(StoryPanel storyPanel) throws DaoException {

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
