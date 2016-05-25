package dao;

import dao.exception.DaoException;
import model.planner.user.ProjectManager;

/**
 * Interface declaring methods to manipulate ProjectManager entities.
 *
 * @author Stefan Pamparau
 */
public interface ProjectManagerDao {
    /**
     * Returns a projectManager based on a specified id.
     *
     * @param id - id of the project manager
     * @return - the projectManager with the specified id, null if the project manager does not
     * exist
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    ProjectManager getProjectManager(Integer id) throws DaoException;

    /**
     * Returns a projectManager based on a specified CNP.
     *
     * @param CNP - CNP of the project manager
     * @return - the projectManager with the specified id, null if the project manager does not
     * exist
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    ProjectManager findProjectManagerByCNP(String CNP) throws DaoException;

    /**
     * Inserts a projectManager into the database.
     *
     * @param projectManager - project manager to be inserted
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    void insertProjectManager(ProjectManager projectManager) throws DaoException;

    /**
     * Updates a projectManager from the database.
     *
     * @param projectManager - project manager to be updated
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    void updateProjectManager(ProjectManager projectManager) throws DaoException;

    /**
     * Deletes a projectManager from the database.
     *
     * @param projectManager - project manager to be deleted.
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    void deleteProjectManager(ProjectManager projectManager) throws DaoException;
}
