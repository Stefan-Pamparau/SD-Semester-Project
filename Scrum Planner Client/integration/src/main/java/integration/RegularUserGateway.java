package integration;

import integration.exception.IntegrationException;
import model.planner.user.RegularUser;

/**
 * Interface which declares all the methods to manipulate RegularUser entities.
 *
 * @author Stefan Pamparau
 */
public interface RegularUserGateway {
    /**
     * Returns a regular user based on a specified id.
     *
     * @param id - id of the regular user
     * @return - the regularUser with the specified id, null if the regularUser does not exist
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    RegularUser getRegularUser(Integer id) throws IntegrationException;

    /**
     * Returns a regular user based on a specified CNP.
     *
     * @param CNP - CNP of the employee
     * @return - the regular user with the specified id, null if the employee does not exist
     * @throws IntegrationException - thrown when a Hibernate exception occurs
     */
    RegularUser findRegularUserByCNP(String CNP) throws IntegrationException;

    /**
     * Inserts a regularUser into the database.
     *
     * @param regularUser - regular user to be inserted
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    void insertRegularUser(RegularUser regularUser) throws IntegrationException;

    /**
     * Updates a regularUser from the database.
     *
     * @param regularUser - regular user to be updated
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    void updateRegularUser(RegularUser regularUser) throws IntegrationException;

    /**
     * Deletes a regularUser from the database.
     *
     * @param regularUser - regular user to be deleted.
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    void deleteRegularUser(RegularUser regularUser) throws IntegrationException;
}
