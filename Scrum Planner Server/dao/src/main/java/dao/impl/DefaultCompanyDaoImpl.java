package dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

import dao.CompanyDao;
import dao.exception.DaoException;
import model.planner.user.Company;

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
        try (Session session = sessionFactory.openSession()) {
            return session.get(Company.class, id);
        } catch (HibernateException e) {
            throw new DaoException("Can not load Company with id:" + id, e);
        }
    }

    @Override
    public Company getCompanyByRegistrationNumber(String registrationNumber) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            List companies = session.createQuery("FROM model.planner.user.Company company WHERE company.registrationNumber = :registrationNumber")
                    .setParameter("registrationNumber", registrationNumber)
                    .list();

            if (companies != null && companies.size() == 1) {
                return (Company) companies.get(0);
            } else {
                return null;
            }
        } catch (HibernateException e) {
            throw new DaoException("Cannot retrieve company with registration number:" + registrationNumber, e);
        }
    }

    @Override
    public void insertCompany(Company company) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            if (getCompanyByRegistrationNumber(company.getRegistrationNumber()) == null) {
                session.save(company);
                session.flush();
            }
        } catch (HibernateException e) {
            throw new DaoException("Cannot insert company", e);
        }
    }

    @Override
    public void updateCompany(Company company) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            Company persistentCompany = getCompanyByRegistrationNumber(company.getRegistrationNumber());
            if (persistentCompany != null) {
                persistentCompany.setCreationDate(company.getCreationDate());
                persistentCompany.setName(company.getName());
                persistentCompany.setRegistrationNumber(company.getRegistrationNumber());
                persistentCompany.setEmployees(company.getEmployees());
                session.update(persistentCompany);
                session.flush();
            }
        } catch (HibernateException e) {
            throw new DaoException("Cannot update company", e);
        }
    }

    @Override
    public void deleteCompany(Company company) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            Company persistentCompany = getCompanyByRegistrationNumber(company.getRegistrationNumber());
            if (persistentCompany != null) {
                session.delete(persistentCompany);
                session.flush();
            }
        } catch (HibernateException e) {
            throw new DaoException("Cannot delete company", e);
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
