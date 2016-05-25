package integration.impl;

import integration.DeveloperGateway;
import integration.exception.IntegrationException;
import model.planner.user.Developer;

/**
 * Default implementation of the DeveloperGateway interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultDeveloperGatewayImpl implements DeveloperGateway {
    @Override
    public Developer getDeveloper(Integer id) throws IntegrationException {
        return null;
    }

    @Override
    public Developer findDeveloperByCNP(String CNP) throws IntegrationException {
        return null;
    }

    @Override
    public void insertDeveloper(Developer developer) throws IntegrationException {

    }

    @Override
    public void updateDeveloper(Developer developer) throws IntegrationException {

    }

    @Override
    public void deleteDeveloper(Developer developer) throws IntegrationException {

    }
}
