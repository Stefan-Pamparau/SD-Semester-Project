package service;

import model.planner.taskboard.TaskPanel;
import service.exception.ServiceException;

/**
 * Interface which declares all the methods necessary to manipulate task panel entities.
 *
 * @author Stefan Pamparau
 */
public interface TaskPanelService {
    /**
     * Returns a task panel based on a specified id.
     *
     * @param id - id of the task panel
     * @return - the task panel with the specified id, null if the taskPanel does not exist
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    TaskPanel getTaskPanel(Integer id) throws ServiceException;

    /**
     * Inserts a task panel into the database.
     *
     * @param taskPanel - task panel to be inserted
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    void insertTaskPanel(TaskPanel taskPanel) throws ServiceException;

    /**
     * Updates a task panel from the database.
     *
     * @param taskPanel - task panel to be updated
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    void updateTaskPanel(TaskPanel taskPanel) throws ServiceException;

    /**
     * Deletes a task panel from the database.
     *
     * @param taskPanel - task panel to be deleted.
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    void deleteTaskPanel(TaskPanel taskPanel) throws ServiceException;
}
