package service;

import model.planner.taskboard.TaskBoard;
import service.exception.ServiceException;

/**
 * Interface which declares all the methods to manipulate task board entities.
 *
 * @author Stefan Pamparau
 */
public interface TaskBoardService {
    /**
     * Returns a task board based on a specified id.
     *
     * @param id - id of the task board
     * @return - the taskBoard with the specified id, null if the taskBoard does not exist
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    TaskBoard getTaskBoard(Integer id) throws ServiceException;

    /**
     * Inserts a task board into the database.
     *
     * @param taskBoard - task board to be inserted
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    void insertTaskBoard(TaskBoard taskBoard) throws ServiceException;

    /**
     * Updates a task board from the database.
     *
     * @param taskBoard - task board to be updated
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    void updateTaskBoard(TaskBoard taskBoard) throws ServiceException;

    /**
     * Deletes a task board from the database.
     *
     * @param taskBoard - task board to be deleted.
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    void deleteTaskBoard(TaskBoard taskBoard) throws ServiceException;
}
