package integration;

import integration.exception.IntegrationException;
import model.planner.taskboard.StoryPanel;

/**
 * Interface which declares all the methods to manipulate story oanel entities.
 *
 * @author Stefan Pamparau
 */
public interface StoryPanelGateway {
    /**
     * Returns a story panel based on a specified id.
     *
     * @param id - id of the storyPanel
     * @return - the storyPanel with the specified id, null if the storyPanel does not exist
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    StoryPanel getStoryPanel(Integer id) throws IntegrationException;

    /**
     * Inserts a storyPanel into the database.
     *
     * @param storyPanel - story panel to be inserted
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    void insertStoryPanel(StoryPanel storyPanel) throws IntegrationException;

    /**
     * Updates a storyPanel from the database.
     *
     * @param storyPanel - story panel to be updated
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    void updateStoryPanel(StoryPanel storyPanel) throws IntegrationException;

    /**
     * Deletes a storyPanel from the database.
     *
     * @param storyPanel - story panel to be deleted.
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    void deleteStoryPanel(StoryPanel storyPanel) throws IntegrationException;
}
