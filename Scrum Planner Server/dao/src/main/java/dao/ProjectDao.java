package dao;

import dao.exception.DaoException;
import model.planner.project.Project;

/**
 * Inteface which declares all the methods to manipulate project entities.
 *
 * @author Stefan Pamparau
 */
public interface ProjectDao {
    /**
     * Returns a project based on a specified id.
     *
     * @param id - id of the project
     * @return - the project with the specified id, null if the project does not exist
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    Project getProject(Integer id) throws DaoException;

    /**
     * Inserts a project into the database.
     *
     * @param project - project to be inserted
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    void insertProject(Project project) throws DaoException;

    /**
     * Updates a project from the database.
     *
     * @param project - project to be updated
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    void updateProject(Project project) throws DaoException;

    /**
     * Deletes a project from the database.
     *
     * @param project - project to be deleted.
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    void deleteProject(Project project) throws DaoException;
}
