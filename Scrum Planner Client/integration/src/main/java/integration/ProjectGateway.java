package integration;

import integration.exception.IntegrationException;
import model.planner.project.Project;

/**
 * Interface which declares all the methods to manipulate project entities.
 *
 * @author Stefan Pamparau
 */
public interface ProjectGateway {
    /**
     * Returns a project based on a specified id.
     *
     * @param id - id of the project
     * @return - the project with the specified id, null if the project does not exist
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    Project getProject(Integer id) throws IntegrationException;

    /**
     * Inserts a project into the database.
     *
     * @param project - project to be inserted
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    void insertProject(Project project) throws IntegrationException;

    /**
     * Updates a project from the database.
     *
     * @param project - project to be updated
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    void updateProject(Project project) throws IntegrationException;

    /**
     * Deletes a project from the database.
     *
     * @param project - project to be deleted.
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    void deleteProject(Project project) throws IntegrationException;
}
