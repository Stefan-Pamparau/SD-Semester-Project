package service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import dao.EmployeeDao;
import dao.exception.DaoException;
import model.planner.user.Employee;
import service.EmployeeService;
import service.exception.ServiceException;

/**
 * Default implementation of the EmployeeService interface.
 *
 * author Stefan Pamparau
 */
public class DefaultEmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Employee getEmployee(Integer id) throws ServiceException {
        try {
            return employeeDao.getEmployee(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void insertEmployee(Employee employee) throws ServiceException {
        try {
            employeeDao.insertEmployee(employee);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void updateEmployee(Employee employee) throws ServiceException {
        try {
            employeeDao.updateEmployee(employee);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void deleteEmployee(Employee employee) throws ServiceException {
        try {
            employeeDao.deleteEmployee(employee);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
