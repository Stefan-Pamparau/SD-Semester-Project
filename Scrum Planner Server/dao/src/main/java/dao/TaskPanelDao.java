package dao;

import dao.exception.DaoException;
import model.planner.taskboard.TaskPanel;

/**
 * Interface which declares all the methods necessary to manipulate task panel entities.
 *
 * @author Stefan Pamparau
 */
public interface TaskPanelDao {
    /**
     * Returns a taskPanel based on a specified id.
     *
     * @param id - id of the task panel
     * @return - the task panel with the specified id, null if the taskPanel does not exist
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    TaskPanel getTaskPanel(Integer id) throws DaoException;

    /**
     * Inserts a task panel into the database.
     *
     * @param taskPanel - task panel to be inserted
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    void insertTaskPanel(TaskPanel taskPanel) throws DaoException;

    /**
     * Updates a task panel from the database.
     *
     * @param taskPanel - task panel to be updated
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    void updateTaskPanel(TaskPanel taskPanel) throws DaoException;

    /**
     * Deletes a task panel from the database.
     *
     * @param taskPanel - task panel to be deleted.
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    void deleteTaskPanel(TaskPanel taskPanel) throws DaoException;
}
