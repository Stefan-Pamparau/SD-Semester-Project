package service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import dao.EmployeeDao;
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
        return null;
    }

    @Override
    public void insertEmployee(Employee employee) throws ServiceException {

    }

    @Override
    public void updateEmployee(Employee employee) throws ServiceException {

    }

    @Override
    public void deleteEmployee(Employee employee) throws ServiceException {

    }

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
