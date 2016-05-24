package dao.impl;

import org.hibernate.SessionFactory;

import dao.RegularUserDao;
import dao.exception.DaoException;
import model.planner.user.RegularUser;

/**
 * Default implementation of the RegularUserDao interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultRegularUserDaoImpl implements RegularUserDao {
    private SessionFactory sessionFactory;

    public DefaultRegularUserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public RegularUser getRegularUser(Integer id) throws DaoException {
        return null;
    }

    @Override
    public void insertRegularUser(RegularUser regularUser) throws DaoException {

    }

    @Override
    public void updateRegularUser(RegularUser regularUser) throws DaoException {

    }

    @Override
    public void deleteRegularUser(RegularUser regularUser) throws DaoException {

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
