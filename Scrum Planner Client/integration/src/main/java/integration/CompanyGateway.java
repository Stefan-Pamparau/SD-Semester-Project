package integration;

import integration.exception.IntegrationException;
import model.planner.user.Developer;

/**
 * Interface declaring all methods to manipulate Company entities.
 *
 * @author Stefan Pamparau
 */
public interface CompanyGateway {
    /**
     * Returns a developer based on a specified id.
     *
     * @param id - id of the developer
     * @return - the developer with the specified id, null if the developer does not exist
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    Developer getDeveloper(Integer id) throws IntegrationException;

    /**
     * Returns a developer based on a specified CNP.
     *
     * @param CNP - CNP of the developer
     * @return - the developer with the specified id, null if the developer does not exist
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    Developer findDeveloperByCNP(String CNP) throws IntegrationException;

    /**
     * Inserts a developer into the database.
     *
     * @param developer - developer to be inserted
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    void insertDeveloper(Developer developer) throws IntegrationException;

    /**
     * Updates a developer from the database.
     *
     * @param developer - developer to be updated
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    void updateDeveloper(Developer developer) throws IntegrationException;

    /**
     * Deletes a developer from the database.
     *
     * @param developer - developer to be deleted.
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    void deleteDeveloper(Developer developer) throws IntegrationException;
}
