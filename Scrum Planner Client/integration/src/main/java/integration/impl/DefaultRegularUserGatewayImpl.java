package integration.impl;

import integration.RegularUserGateway;
import integration.exception.IntegrationException;
import model.planner.user.RegularUser;

/**
 * Default implementation of the RegularUserGateway interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultRegularUserGatewayImpl implements RegularUserGateway {
    @Override
    public RegularUser getRegularUser(Integer id) throws IntegrationException {
        return null;
    }

    @Override
    public RegularUser findRegularUserByCNP(String CNP) throws IntegrationException {
        return null;
    }

    @Override
    public void insertRegularUser(RegularUser regularUser) throws IntegrationException {

    }

    @Override
    public void updateRegularUser(RegularUser regularUser) throws IntegrationException {

    }

    @Override
    public void deleteRegularUser(RegularUser regularUser) throws IntegrationException {

    }
}
