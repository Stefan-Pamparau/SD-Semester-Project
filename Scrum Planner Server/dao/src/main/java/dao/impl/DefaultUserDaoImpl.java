package dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

import dao.UserDao;
import dao.exception.DaoException;
import model.planner.user.User;

/**
 * Default implementation of the UserDao interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultUserDaoImpl implements UserDao {
    private SessionFactory sessionFactory;

    public DefaultUserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            List user = session.createQuery("FROM model.planner.user.User user WHERE user.email = :email AND user.password = :password")
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .list();

            if (user != null && user.size() == 1) {
                return (User) user.get(0);
            } else {
                return null;
            }
        } catch (HibernateException e) {
            throw new DaoException("Cannot retrieve username with email:" + email + " and password:" + password, e);
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
