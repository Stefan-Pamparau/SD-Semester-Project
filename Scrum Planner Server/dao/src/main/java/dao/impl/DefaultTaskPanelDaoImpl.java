package dao.impl;

import org.hibernate.SessionFactory;

import dao.TaskPanelDao;
import dao.exception.DaoException;
import model.planner.taskboard.TaskPanel;

/**
 * Default implementation of the TaskPanelDao interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultTaskPanelDaoImpl implements TaskPanelDao {
    private SessionFactory sessionFactory;

    public DefaultTaskPanelDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public TaskPanel getTaskPanel(Integer id) throws DaoException {
        return null;
    }

    @Override
    public void insertTaskPanel(TaskPanel taskPanel) throws DaoException {

    }

    @Override
    public void updateTaskPanel(TaskPanel taskPanel) throws DaoException {

    }

    @Override
    public void deleteTaskPanel(TaskPanel taskPanel) throws DaoException {

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
