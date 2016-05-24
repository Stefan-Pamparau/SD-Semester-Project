package service;

import model.planner.user.Employee;
import service.exception.ServiceException;

/**
 * Interface which declares methods to manipulate employee entities.
 *
 * @author Stefan Pamparau
 */
public interface EmployeeService {
    /**
     * Returns a employee based on a specified id.
     *
     * @param id - id of the employee
     * @return - the employee with the specified id, null if the employee does not exist
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    Employee getEmployee(Integer id) throws ServiceException;

    /**
     * Inserts a employee into the database.
     *
     * @param employee - employee to be inserted
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    void insertEmployee(Employee employee) throws ServiceException;

    /**
     * Updates a employee from the database.
     *
     * @param employee - employee to be updated
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    void updateEmployee(Employee employee) throws ServiceException;

    /**
     * Deletes a employee from the database.
     *
     * @param employee - employee to be deleted.
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    void deleteEmployee(Employee employee) throws ServiceException;
}
