package service;

import model.planner.taskboard.StoryPanel;
import service.exception.ServiceException;

/**
 * Interface which declares all the methods to manipulate story oanel entities.
 *
 * @author Stefan Pamparau
 */
public interface StoryPanelService {
    /**
     * Returns a story panel based on a specified id.
     *
     * @param id - id of the storyPanel
     * @return - the storyPanel with the specified id, null if the storyPanel does not exist
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    StoryPanel getStoryPanel(Integer id) throws ServiceException;

    /**
     * Inserts a storyPanel into the database.
     *
     * @param storyPanel - story panel to be inserted
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    void insertStoryPanel(StoryPanel storyPanel) throws ServiceException;

    /**
     * Updates a storyPanel from the database.
     *
     * @param storyPanel - story panel to be updated
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    void updateStoryPanel(StoryPanel storyPanel) throws ServiceException;

    /**
     * Deletes a storyPanel from the database.
     *
     * @param storyPanel - story panel to be deleted.
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    void deleteStoryPanel(StoryPanel storyPanel) throws ServiceException;
}
