package integration.impl;

import integration.TaskPanelGateway;
import integration.exception.IntegrationException;
import model.planner.taskboard.TaskPanel;

/**
 * Default implementation of the TaskPanelGateway interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultTaskPanelGatewayImpl implements TaskPanelGateway {
    @Override
    public TaskPanel getTaskPanel(Integer id) throws IntegrationException {
        return null;
    }

    @Override
    public void insertTaskPanel(TaskPanel taskPanel) throws IntegrationException {

    }

    @Override
    public void updateTaskPanel(TaskPanel taskPanel) throws IntegrationException {

    }

    @Override
    public void deleteTaskPanel(TaskPanel taskPanel) throws IntegrationException {

    }
}
