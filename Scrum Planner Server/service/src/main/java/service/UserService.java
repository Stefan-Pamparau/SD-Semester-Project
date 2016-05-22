package service;

import model.user.User;
import service.exception.ServiceException;

/**
 * Interface which declares all methods to manipulate user entities.
 *
 * @author Stefan Pamparau
 */
public interface UserService {
    /**
     * Returns an user based on his email and password
     *
     * @param email    - the email of the user
     * @param password - the password of the user
     * @return - the user if it exists, null otherwise
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    User getUserByEmailAndPassword(String email, String password) throws ServiceException;
}
