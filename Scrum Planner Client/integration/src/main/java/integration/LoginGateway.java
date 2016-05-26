package integration;

import integration.exception.IntegrationException;
import model.planner.user.User;

/**
 * Interface which declares all methods to manipulate user entities.
 *
 * @author Stefan Pamparau
 */
public interface LoginGateway {
    /**
     * Returns an user based on his email and password
     *
     * @param email    - the email of the user
     * @param password - the password of the user
     * @return - the user if it exists, null otherwise
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    User getUserByEmailAndPassword(String email, String password) throws IntegrationException;

    /**
     * @return - returns the currently logged user
     */
    User getCurrentlyLoggedUser();
}
