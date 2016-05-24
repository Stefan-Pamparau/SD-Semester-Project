package dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public TaskBoard getTaskBoard(Integer id) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            return session.get(TaskBoard.class, id);
        } catch (HibernateException e) {
            throw new DaoException("Cannot retrieve task board with id:" + id, e);
        }
    }

    @Override
    @Transactional
    public void insertTaskBoard(TaskBoard taskBoard) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            session.save(taskBoard);
        } catch (HibernateException e) {
            throw new DaoException("Cannot insert task board", e);
        }
    }

    @Override
    @Transactional
    public void updateTaskBoard(TaskBoard taskBoard) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            TaskBoard persistentTaskBoard = session.get(TaskBoard.class, taskBoard.getId());

            if (persistentTaskBoard != null) {
                persistentTaskBoard.setPanels(taskBoard.getPanels());
                session.update(persistentTaskBoard);
            }
        } catch (HibernateException e) {
            throw new DaoException("Cannot update task board", e);
        }
    }

    @Override
    @Transactional
    public void deleteTaskBoard(TaskBoard taskBoard) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            TaskBoard persistentTaskBoard = session.get(TaskBoard.class, taskBoard.getId());

            if (persistentTaskBoard != null) {
                session.delete(persistentTaskBoard);
            }
        } catch (HibernateException e) {
            throw new DaoException("Cannot delete task board", e);
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
