package dao.impl;

import org.hibernate.SessionFactory;

import dao.CompanyDao;
import dao.exception.DaoException;
import model.user.Company;

/**
 * Default implementation of the COmpanyDao interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultCompanyDaoImpl implements CompanyDao {
    private SessionFactory sessionFactory;

    public DefaultCompanyDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Company getCompany(Integer id) throws DaoException {
        return null;
    }

    @Override
    public void insertCompany(Company company) throws DaoException {

    }

    @Override
    public void updateCompany(Company company) throws DaoException {

    }

    @Override
    public void deleteCompany(Company company) throws DaoException {

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
