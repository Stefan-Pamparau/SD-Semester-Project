package dao;

import dao.exception.DaoException;
import model.planner.user.Employee;

/**
 * Interface which declares methods to manipulate employee entities.
 *
 * @author Stefan Pamparau
 */
public interface EmployeeDao {
    /**
     * Returns a employee based on a specified id.
     *
     * @param id - id of the employee
     * @return - the employee with the specified id, null if the employee does not exist
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    Employee getEmployee(Integer id) throws DaoException;

    /**
     * Inserts a employee into the database.
     *
     * @param employee - employee to be inserted
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    void insertEmployee(Employee employee) throws DaoException;

    /**
     * Updates a employee from the database.
     *
     * @param employee - employee to be updated
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    void updateEmployee(Employee employee) throws DaoException;

    /**
     * Deletes a employee from the database.
     *
     * @param employee - employee to be deleted.
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    void deleteEmployee(Employee employee) throws DaoException;
}
