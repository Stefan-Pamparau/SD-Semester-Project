package dao;

import model.user.User;

/**
 * Interface which declares all methods to manipulate user entities.
 *
 * @author Stefan Pamparau
 */
public interface UserDao {

    /**
     * Returns an user based on his email and password
     *
     * @param email    - the email of the user
     * @param password - the password of the user
     * @return - the user if it exists, null otherwise
     */
    User getUserByEmailAndPassword(String email, String password);
}
