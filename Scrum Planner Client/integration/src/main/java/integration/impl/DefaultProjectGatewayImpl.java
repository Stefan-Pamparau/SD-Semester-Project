package integration.impl;

import integration.ProjectGateway;
import integration.exception.IntegrationException;
import model.planner.project.Project;

/**
 * Default implementation of the ProjectGateway interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultProjectGatewayImpl implements ProjectGateway {
    @Override
    public Project getProject(Integer id) throws IntegrationException {
        return null;
    }

    @Override
    public void insertProject(Project project) throws IntegrationException {

    }

    @Override
    public void updateProject(Project project) throws IntegrationException {

    }

    @Override
    public void deleteProject(Project project) throws IntegrationException {

    }
}
