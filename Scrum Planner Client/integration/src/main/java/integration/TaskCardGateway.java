package integration;

import integration.exception.IntegrationException;
import model.planner.card.TaskCard;

/**
 * Interface which declares all the methods to manipulate task card entities.
 *
 * @author Stefan Pamparau
 */
public interface TaskCardGateway {
    /**
     * Returns a task card based on a specified id.
     *
     * @param id - id of the task card
     * @return - the task card with the specified id, null if the taskCard does not exist
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    TaskCard getTaskCard(Integer id) throws IntegrationException;

    /**
     * Inserts a task card into the database.
     *
     * @param taskCard - task card to be inserted
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    TaskCard insertTaskCard(TaskCard taskCard) throws IntegrationException;

    /**
     * Updates a task card from the database.
     *
     * @param taskCard - task card to be updated
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    void updateTaskCard(TaskCard taskCard) throws IntegrationException;

    /**
     * Deletes a task card from the database.
     *
     * @param taskCard - task card to be deleted.
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    void deleteTaskCard(TaskCard taskCard) throws IntegrationException;
}
