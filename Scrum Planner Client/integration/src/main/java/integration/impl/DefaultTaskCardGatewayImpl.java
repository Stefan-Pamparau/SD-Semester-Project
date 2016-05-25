package integration.impl;

import integration.TaskCardGateway;
import integration.exception.IntegrationException;
import model.planner.card.TaskCard;

/**
 * Default implementation of the TaskCardGateway interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultTaskCardGatewayImpl implements TaskCardGateway {
    @Override
    public TaskCard getTaskCard(Integer id) throws IntegrationException {
        return null;
    }

    @Override
    public void insertTaskCard(TaskCard taskCard) throws IntegrationException {

    }

    @Override
    public void updateTaskCard(TaskCard taskCard) throws IntegrationException {

    }

    @Override
    public void deleteTaskCard(TaskCard taskCard) throws IntegrationException {

    }
}
