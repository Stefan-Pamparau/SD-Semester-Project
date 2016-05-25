package integration.impl;

import integration.TaskBoardGateway;
import integration.exception.IntegrationException;
import model.planner.taskboard.TaskBoard;

/**
 * Default implementation of the TaskBoardGateway interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultTaskBoardGatewayImpl implements TaskBoardGateway {
    @Override
    public TaskBoard getTaskBoard(Integer id) throws IntegrationException {
        return null;
    }

    @Override
    public void insertTaskBoard(TaskBoard taskBoard) throws IntegrationException {

    }

    @Override
    public void updateTaskBoard(TaskBoard taskBoard) throws IntegrationException {

    }

    @Override
    public void deleteTaskBoard(TaskBoard taskBoard) throws IntegrationException {

    }
}
