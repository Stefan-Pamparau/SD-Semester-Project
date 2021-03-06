package dao;

import dao.exception.DaoException;
import model.planner.user.RegularUser;

/**
 * Interface which declares all the methods to manipulate RegularUser entities.
 *
 * @author Stefan Pamparau
 */
public interface RegularUserDao {
    /**
     * Returns a regular user based on a specified id.
     *
     * @param id - id of the regular user
     * @return - the regularUser with the specified id, null if the regularUser does not exist
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    RegularUser getRegularUser(Integer id) throws DaoException;

    /**
     * Returns a regular user based on a specified CNP.
     *
     * @param CNP - CNP of the employee
     * @return - the regular user with the specified id, null if the employee does not exist
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    RegularUser findRegularUserByCNP(String CNP) throws DaoException;

    /**
     * Inserts a regularUser into the database.
     *
     * @param regularUser - regular user to be inserted
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    void insertRegularUser(RegularUser regularUser) throws DaoException;

    /**
     * Updates a regularUser from the database.
     *
     * @param regularUser - regular user to be updated
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    void updateRegularUser(RegularUser regularUser) throws DaoException;

    /**
     * Deletes a regularUser from the database.
     *
     * @param regularUser - regular user to be deleted.
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    void deleteRegularUser(RegularUser regularUser) throws DaoException;
}
