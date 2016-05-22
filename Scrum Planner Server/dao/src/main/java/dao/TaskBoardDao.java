package dao;

import dao.exception.DaoException;
import model.planner.taskboard.TaskBoard;

/**
 * Interface which declares all the methods to manipulate task board entities.
 *
 * @author Stefan Pamparau
 */
public interface TaskBoardDao {
    /**
     * Returns a task board based on a specified id.
     *
     * @param id - id of the task board
     * @return - the taskBoard with the specified id, null if the taskBoard does not exist
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    TaskBoard getTaskBoard(Integer id) throws DaoException;

    /**
     * Inserts a task board into the database.
     *
     * @param taskBoard - task board to be inserted
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    void insertTaskBoard(TaskBoard taskBoard) throws DaoException;

    /**
     * Updates a task board from the database.
     *
     * @param taskBoard - task board to be updated
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    void updateTaskBoard(TaskBoard taskBoard) throws DaoException;

    /**
     * Deletes a task board from the database.
     *
     * @param taskBoard - task board to be deleted.
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    void deleteTaskBoard(TaskBoard taskBoard) throws DaoException;
}
