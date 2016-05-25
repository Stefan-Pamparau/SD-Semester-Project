package dao;

import dao.exception.DaoException;
import model.planner.user.Developer;

/**
 * Interface which declares methods to manipulate Developer entities.
 *
 * @author Stefan Pamparau
 */
public interface DeveloperDao {
    /**
     * Returns a developer based on a specified id.
     *
     * @param id - id of the developer
     * @return - the developer with the specified id, null if the developer does not exist
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    Developer getDeveloper(Integer id) throws DaoException;

    /**
     * Returns a developer based on a specified CNP.
     *
     * @param CNP - CNP of the developer
     * @return - the developer with the specified id, null if the developer does not exist
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    Developer findDeveloperByCNP(String CNP) throws DaoException;

    /**
     * Inserts a developer into the database.
     *
     * @param developer - developer to be inserted
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    void insertDeveloper(Developer developer) throws DaoException;

    /**
     * Updates a developer from the database.
     *
     * @param developer - developer to be updated
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    void updateDeveloper(Developer developer) throws DaoException;

    /**
     * Deletes a developer from the database.
     *
     * @param developer - developer to be deleted.
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    void deleteDeveloper(Developer developer) throws DaoException;
}
