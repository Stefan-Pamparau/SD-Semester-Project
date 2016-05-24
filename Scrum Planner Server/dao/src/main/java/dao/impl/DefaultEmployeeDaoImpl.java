package dao.impl;

import org.hibernate.SessionFactory;

import dao.EmployeeDao;
import dao.exception.DaoException;
import model.planner.user.Employee;

/**
 * Default implementation of the EmployeeDao interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultEmployeeDaoImpl implements EmployeeDao {
    private SessionFactory sessionFactory;

    public DefaultEmployeeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Employee getEmployee(Integer id) throws DaoException {
        return null;
    }

    @Override
    public void insertEmployee(Employee employee) throws DaoException {

    }

    @Override
    public void updateEmployee(Employee employee) throws DaoException {

    }

    @Override
    public void deleteEmployee(Employee employee) throws DaoException {

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
