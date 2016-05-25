package integration;

import integration.exception.IntegrationException;
import model.planner.user.ProjectManager;

/**
 * Interface declaring methods to manipulate ProjectManager entities.
 *
 * @author Stefan Pamparau
 */
public interface ProjectManagerGateway {
    /**
     * Returns a projectManager based on a specified id.
     *
     * @param id - id of the project manager
     * @return - the projectManager with the specified id, null if the project manager does not
     * exist
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    ProjectManager getProjectManager(Integer id) throws IntegrationException;

    /**
     * Returns a projectManager based on a specified CNP.
     *
     * @param CNP - CNP of the project manager
     * @return - the projectManager with the specified id, null if the project manager does not
     * exist
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    ProjectManager findProjectManagerByCNP(String CNP) throws IntegrationException;

    /**
     * Inserts a projectManager into the database.
     *
     * @param projectManager - project manager to be inserted
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    void insertProjectManager(ProjectManager projectManager) throws IntegrationException;

    /**
     * Updates a projectManager from the database.
     *
     * @param projectManager - project manager to be updated
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    void updateProjectManager(ProjectManager projectManager) throws IntegrationException;

    /**
     * Deletes a projectManager from the database.
     *
     * @param projectManager - project manager to be deleted.
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    void deleteProjectManager(ProjectManager projectManager) throws IntegrationException;
}
