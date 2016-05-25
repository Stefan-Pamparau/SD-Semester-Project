package service;

import model.planner.user.Developer;
import service.exception.ServiceException;

/**
 * Interface which declares methods to manipulate Developer entities.
 *
 * @author Stefan Pamparau
 */
public interface DeveloperService {
    /**
     * Returns a developer based on a specified id.
     *
     * @param id - id of the developer
     * @return - the developer with the specified id, null if the developer does not exist
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    Developer getDeveloper(Integer id) throws ServiceException;

    /**
     * Returns a developer based on a specified CNP.
     *
     * @param CNP - CNP of the developer
     * @return - the developer with the specified id, null if the developer does not exist
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    Developer findDeveloperByCNP(String CNP) throws ServiceException;

    /**
     * Inserts a developer into the database.
     *
     * @param developer - developer to be inserted
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    void insertDeveloper(Developer developer) throws ServiceException;

    /**
     * Updates a developer from the database.
     *
     * @param developer - developer to be updated
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    void updateDeveloper(Developer developer) throws ServiceException;

    /**
     * Deletes a developer from the database.
     *
     * @param developer - developer to be deleted.
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    void deleteDeveloper(Developer developer) throws ServiceException;
}
