package dao;

import dao.exception.DaoException;
import model.planner.card.TaskCard;

/**
 * Interface which declares all the methods to manipulate task card entities.
 *
 * @author Stefan Pamparau
 */
public interface TaskCardDao {
    /**
     * Returns a task card based on a specified id.
     *
     * @param id - id of the task card
     * @return - the task card with the specified id, null if the taskCard does not exist
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    TaskCard getTaskCard(Integer id) throws DaoException;

    /**
     * Inserts a task card into the database.
     *
     * @param taskCard - task card to be inserted
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    void insertTaskCard(TaskCard taskCard) throws DaoException;

    /**
     * Updates a task card from the database.
     *
     * @param taskCard - task card to be updated
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    void updateTaskCard(TaskCard taskCard) throws DaoException;

    /**
     * Deletes a task card from the database.
     *
     * @param taskCard - task card to be deleted.
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    void deleteTaskCard(TaskCard taskCard) throws DaoException;
}
