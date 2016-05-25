package integration;

import integration.exception.IntegrationException;
import model.planner.user.Employee;

/**
 * Interface which declares methods to manipulate employee entities.
 *
 * @author Stefan Pamparau
 */
public interface EmployeeGateway {
    /**
     * Returns a employee based on a specified id.
     *
     * @param id - id of the employee
     * @return - the employee with the specified id, null if the employee does not exist
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    Employee getEmployee(Integer id) throws IntegrationException;

    /**
     * Returns a employee based on a specified CNP.
     *
     * @param CNP - CNP of the employee
     * @return - the employee with the specified id, null if the employee does not exist
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    Employee findEmployeeByCNP(String CNP) throws IntegrationException;

    /**
     * Inserts a employee into the database.
     *
     * @param employee - employee to be inserted
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    Employee insertEmployee(Employee employee) throws IntegrationException;

    /**
     * Updates a employee from the database.
     *
     * @param employee - employee to be updated
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    void updateEmployee(Employee employee) throws IntegrationException;

    /**
     * Deletes a employee from the database.
     *
     * @param employee - employee to be deleted.
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    void deleteEmployee(Employee employee) throws IntegrationException;
}
