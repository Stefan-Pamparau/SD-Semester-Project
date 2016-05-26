package dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public TaskCard getTaskCard(Integer id) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            return session.get(TaskCard.class, id);
        } catch (HibernateException e) {
            throw new DaoException("Cannot retrieve task card with id:" + id, e);
        }
    }

    @Override
    @Transactional
    public void insertTaskCard(TaskCard taskCard) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            session.save(taskCard);
        } catch (HibernateException e) {
            throw new DaoException("Cannot insert task card", e);
        }
    }

    @Override
    @Transactional
    public void updateTaskCard(TaskCard taskCard) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            TaskCard persistentTaskCard = session.get(TaskCard.class, taskCard.getId());

            if (persistentTaskCard != null) {
                persistentTaskCard.setTitle(taskCard.getTitle());
                persistentTaskCard.setDescription(taskCard.getDescription());
//                persistentTaskCard.setPanel(taskCard.getPanel());
                persistentTaskCard.setFinishEstimation(taskCard.getFinishEstimation());
                persistentTaskCard.setState(taskCard.getState());
                persistentTaskCard.setTags(taskCard.getTags());
//                persistentTaskCard.setTaskPanel(taskCard.getTaskPanel());
                session.update(persistentTaskCard);
                session.flush();
            }
        } catch (HibernateException e) {
            throw new DaoException("Cannot update task card", e);
        }
    }

    @Override
    @Transactional
    public void deleteTaskCard(TaskCard taskCard) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            TaskCard persistentTaskCard = session.get(TaskCard.class, taskCard.getId());

            if (persistentTaskCard != null) {
                session.delete(persistentTaskCard);
                session.flush();
            }
        } catch (HibernateException e) {
            throw new DaoException("Cannot delete task card", e);
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
