package service;

import model.planner.user.RegularUser;
import service.exception.ServiceException;

/**
 * Interface which declares all the methods to manipulate RegularUser entities.
 *
 * @author Stefan Pamparau
 */
public interface RegularUserService {
    /**
     * Returns a regular user based on a specified id.
     *
     * @param id - id of the regular user
     * @return - the regularUser with the specified id, null if the regularUser does not exist
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    RegularUser getRegularUser(Integer id) throws ServiceException;

    /**
     * Returns a regular user based on a specified CNP.
     *
     * @param CNP - CNP of the employee
     * @return - the regular user with the specified id, null if the employee does not exist
     * @throws ServiceException - thrown when a Hibernate exception occurs
     */
    RegularUser findRegularUserByCNP(String CNP) throws ServiceException;

    /**
     * Inserts a regularUser into the database.
     *
     * @param regularUser - regular user to be inserted
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    void insertRegularUser(RegularUser regularUser) throws ServiceException;

    /**
     * Updates a regularUser from the database.
     *
     * @param regularUser - regular user to be updated
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    void updateRegularUser(RegularUser regularUser) throws ServiceException;

    /**
     * Deletes a regularUser from the database.
     *
     * @param regularUser - regular user to be deleted.
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    void deleteRegularUser(RegularUser regularUser) throws ServiceException;
}
