package dao.impl;

import org.hibernate.SessionFactory;

import dao.TaskCardDao;
import dao.exception.DaoException;
import model.planner.card.TaskCard;

/**
 * Default implementation of the TaskCardDao interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultTaskCardDaoImpl implements TaskCardDao {
    private SessionFactory sessionFactory;

    public DefaultTaskCardDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public TaskCard getTaskCard(Integer id) throws DaoException {
        return null;
    }

    @Override
    public void insertTaskCard(TaskCard taskCard) throws DaoException {

    }

    @Override
    public void updateTaskCard(TaskCard taskCard) throws DaoException {

    }

    @Override
    public void deleteTaskCard(TaskCard taskCard) throws DaoException {

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
