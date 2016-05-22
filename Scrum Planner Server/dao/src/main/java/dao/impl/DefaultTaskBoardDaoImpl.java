package dao.impl;

import org.hibernate.SessionFactory;

import dao.TaskBoardDao;
import dao.exception.DaoException;
import model.planner.taskboard.TaskBoard;

/**
 * Default implementation ofthe TaskBoardDao interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultTaskBoardDaoImpl implements TaskBoardDao {
    private SessionFactory sessionFactory;

    public DefaultTaskBoardDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public TaskBoard getTaskBoard(Integer id) throws DaoException {
        return null;
    }

    @Override
    public void insertTaskBoard(TaskBoard taskBoard) throws DaoException {

    }

    @Override
    public void updateTaskBoard(TaskBoard taskBoard) throws DaoException {

    }

    @Override
    public void deleteTaskBoard(TaskBoard taskBoard) throws DaoException {

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
