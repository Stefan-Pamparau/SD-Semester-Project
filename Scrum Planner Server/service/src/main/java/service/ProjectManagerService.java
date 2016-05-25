package service;

import model.planner.user.ProjectManager;
import service.exception.ServiceException;

/**
 * Interface declaring methods to manipulate ProjectManager entities.
 *
 * @author Stefan Pamparau
 */
public interface ProjectManagerService {
    /**
     * Returns a projectManager based on a specified id.
     *
     * @param id - id of the project manager
     * @return - the projectManager with the specified id, null if the project manager does not
     * exist
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    ProjectManager getProjectManager(Integer id) throws ServiceException;

    /**
     * Returns a projectManager based on a specified CNP.
     *
     * @param CNP - CNP of the project manager
     * @return - the projectManager with the specified id, null if the project manager does not
     * exist
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    ProjectManager findProjectManagerByCNP(String CNP) throws ServiceException;

    /**
     * Inserts a projectManager into the database.
     *
     * @param projectManager - project manager to be inserted
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    void insertProjectManager(ProjectManager projectManager) throws ServiceException;

    /**
     * Updates a projectManager from the database.
     *
     * @param projectManager - project manager to be updated
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    void updateProjectManager(ProjectManager projectManager) throws ServiceException;

    /**
     * Deletes a projectManager from the database.
     *
     * @param projectManager - project manager to be deleted.
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    void deleteProjectManager(ProjectManager projectManager) throws ServiceException;
}
