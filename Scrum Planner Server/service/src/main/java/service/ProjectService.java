package service;

import model.planner.project.Project;
import service.exception.ServiceException;

/**
 * Interface which declares all the methods to manipulate project entities.
 *
 * @author Stefan Pamparau
 */
public interface ProjectService {
    /**
     * Returns a project based on a specified id.
     *
     * @param id - id of the project
     * @return - the project with the specified id, null if the project does not exist
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    Project getProject(Integer id) throws ServiceException;

    /**
     * Inserts a project into the database.
     *
     * @param project - project to be inserted
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    void insertProject(Project project) throws ServiceException;

    /**
     * Updates a project from the database.
     *
     * @param project - project to be updated
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    void updateProject(Project project) throws ServiceException;

    /**
     * Deletes a project from the database.
     *
     * @param project - project to be deleted.
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    void deleteProject(Project project) throws ServiceException;
}
