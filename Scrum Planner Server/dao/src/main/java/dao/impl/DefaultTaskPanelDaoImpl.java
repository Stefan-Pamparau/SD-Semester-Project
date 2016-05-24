package dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public TaskPanel getTaskPanel(Integer id) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            return session.get(TaskPanel.class, id);
        } catch (HibernateException e) {
            throw new DaoException("Cannot retrieve task panel with id:" + id, e);
        }
    }

    @Override
    @Transactional
    public void insertTaskPanel(TaskPanel taskPanel) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            session.save(taskPanel);
        } catch (HibernateException e) {
            throw new DaoException("Cannot insert task panel", e);
        }
    }

    @Override
    @Transactional
    public void updateTaskPanel(TaskPanel taskPanel) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            TaskPanel persistentTaskPanel = session.get(TaskPanel.class, taskPanel.getId());

            if (persistentTaskPanel != null) {
                persistentTaskPanel.setTaskCards(taskPanel.getTaskCards());
                session.update(persistentTaskPanel);
            }
        } catch (HibernateException e) {
            throw new DaoException("Cannot update task panel", e);
        }
    }

    @Override
    @Transactional
    public void deleteTaskPanel(TaskPanel taskPanel) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            TaskPanel persistentTaskPanel = session.get(TaskPanel.class, taskPanel.getId());

            if (persistentTaskPanel != null) {
                session.delete(persistentTaskPanel);
            }
        } catch (HibernateException e) {
            throw new DaoException("Cannot delete task panel", e);
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
