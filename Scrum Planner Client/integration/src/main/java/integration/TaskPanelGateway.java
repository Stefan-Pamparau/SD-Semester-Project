package integration;

import integration.exception.IntegrationException;
import model.planner.taskboard.TaskPanel;

/**
 * Interface which declares all the methods necessary to manipulate task panel entities.
 *
 * @author Stefan Pamparau
 */
public interface TaskPanelGateway {
    /**
     * Returns a task panel based on a specified id.
     *
     * @param id - id of the task panel
     * @return - the task panel with the specified id, null if the taskPanel does not exist
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    TaskPanel getTaskPanel(Integer id) throws IntegrationException;

    /**
     * Inserts a task panel into the database.
     *
     * @param taskPanel - task panel to be inserted
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    void insertTaskPanel(TaskPanel taskPanel) throws IntegrationException;

    /**
     * Updates a task panel from the database.
     *
     * @param taskPanel - task panel to be updated
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    void updateTaskPanel(TaskPanel taskPanel) throws IntegrationException;

    /**
     * Deletes a task panel from the database.
     *
     * @param taskPanel - task panel to be deleted.
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    void deleteTaskPanel(TaskPanel taskPanel) throws IntegrationException;
}
