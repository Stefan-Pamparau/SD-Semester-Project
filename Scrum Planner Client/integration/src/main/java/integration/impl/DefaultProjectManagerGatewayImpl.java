package integration.impl;

import integration.ProjectManagerGateway;
import integration.exception.IntegrationException;
import model.planner.user.ProjectManager;

/**
 * Default implementation of the ProjectManagerGateway interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultProjectManagerGatewayImpl implements ProjectManagerGateway {
    @Override
    public ProjectManager getProjectManager(Integer id) throws IntegrationException {
        return null;
    }

    @Override
    public ProjectManager findProjectManagerByCNP(String CNP) throws IntegrationException {
        return null;
    }

    @Override
    public void insertProjectManager(ProjectManager projectManager) throws IntegrationException {

    }

    @Override
    public void updateProjectManager(ProjectManager projectManager) throws IntegrationException {

    }

    @Override
    public void deleteProjectManager(ProjectManager projectManager) throws IntegrationException {

    }
}
