package integration.impl;

import integration.UserGateway;
import integration.exception.IntegrationException;
import model.planner.user.User;

/**
 * Default implementation of the UserGateway interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultUserGatewayImpl implements UserGateway {
    @Override
    public User getUserByEmailAndPassword(String email, String password) throws IntegrationException {
        return null;
    }
}
