package dao.impl;

import org.hibernate.SessionFactory;

import dao.UserDao;
import model.user.User;

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
    public User getUserByEmailAndPassword(String email, String password) {
        return null;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
