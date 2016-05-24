package dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    @Transactional
    public Employee getEmployee(Integer id) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Employee.class, id);
        } catch (HibernateException e) {
            throw new DaoException("Cannot retrieve employee with id:" + id, e);
        }
    }

    @Override
    @Transactional
    public Employee findEmployeeByCNP(String CNP) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            List employee = session.createQuery("FROM model.planner.user.Employee employee WHERE employee.CNP = :CNP")
                    .setParameter("CNP", CNP)
                    .list();

            if (employee != null && employee.size() == 1) {
                return (Employee) employee.get(0);
            } else {
                return null;
            }
        } catch (HibernateException e) {
            throw new DaoException("Cannot retrieve employee with CNP:" + CNP, e);
        }
    }

    @Override
    @Transactional
    public void insertEmployee(Employee employee) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            if (findEmployeeByCNP(employee.getCNP()) == null) {
                session.save(employee);
                session.flush();
            }
        } catch (HibernateException e) {
            throw new DaoException("Cannot insert employee", e);
        }
    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            Employee persistentEmployee = findEmployeeByCNP(employee.getCNP());
            if (persistentEmployee != null) {
                persistentEmployee.setName(employee.getName());
                persistentEmployee.setEmail(employee.getEmail());
                persistentEmployee.setCompany(employee.getCompany());
                persistentEmployee.setAge(employee.getAge());
                persistentEmployee.setPassword(employee.getPassword());
                persistentEmployee.setProjects(employee.getProjects());
                session.update(persistentEmployee);
                session.flush();
            }
        } catch (HibernateException e) {
            throw new DaoException("Cannot update employee", e);
        }
    }

    @Override
    @Transactional
    public void deleteEmployee(Employee employee) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            Employee persistentEmployee = findEmployeeByCNP(employee.getCNP());
            if (persistentEmployee != null) {
                session.delete(persistentEmployee);
                session.flush();
            }
        } catch (HibernateException e) {
            throw new DaoException("Cannot delete employee", e);
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
