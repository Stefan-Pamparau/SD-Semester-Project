package integration;

import integration.exception.IntegrationException;
import model.planner.taskboard.TaskBoard;

/**
 * Interface which declares all the methods to manipulate task board entities.
 *
 * @author Stefan Pamparau
 */
public interface TaskBoardGateway {
    /**
     * Returns a task board based on a specified id.
     *
     * @param id - id of the task board
     * @return - the taskBoard with the specified id, null if the taskBoard does not exist
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    TaskBoard getTaskBoard(Integer id) throws IntegrationException;

    /**
     * Inserts a task board into the database.
     *
     * @param taskBoard - task board to be inserted
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    TaskBoard insertTaskBoard(TaskBoard taskBoard) throws IntegrationException;

    /**
     * Updates a task board from the database.
     *
     * @param taskBoard - task board to be updated
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    void updateTaskBoard(TaskBoard taskBoard) throws IntegrationException;

    /**
     * Deletes a task board from the database.
     *
     * @param taskBoard - task board to be deleted.
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    void deleteTaskBoard(TaskBoard taskBoard) throws IntegrationException;
}
