package service;

import model.planner.card.TaskCard;
import service.exception.ServiceException;

/**
 * Interface which declares all the methods to manipulate task card entities.
 *
 * @author Stefan Pamparau
 */
public interface TaskCardService {
    /**
     * Returns a task card based on a specified id.
     *
     * @param id - id of the task card
     * @return - the task card with the specified id, null if the taskCard does not exist
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    TaskCard getTaskCard(Integer id) throws ServiceException;

    /**
     * Inserts a task card into the database.
     *
     * @param taskCard - task card to be inserted
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    void insertTaskCard(TaskCard taskCard) throws ServiceException;

    /**
     * Updates a task card from the database.
     *
     * @param taskCard - task card to be updated
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    void updateTaskCard(TaskCard taskCard) throws ServiceException;

    /**
     * Deletes a task card from the database.
     *
     * @param taskCard - task card to be deleted.
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    void deleteTaskCard(TaskCard taskCard) throws ServiceException;
}
