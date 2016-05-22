package dao;

import dao.exception.DaoException;
import model.planner.taskboard.StoryPanel;

/**
 * Interface which declares all the methods to manipulate story oanel entities.
 *
 * @author Stefan Pamparau
 */
public interface StoryPanelDao {
    /**
     * Returns a story panel based on a specified id.
     *
     * @param id - id of the storyPanel
     * @return - the storyPanel with the specified id, null if the storyPanel does not exist
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    StoryPanel getStoryPanel(Integer id) throws DaoException;

    /**
     * Inserts a storyPanel into the database.
     *
     * @param storyPanel - story panel to be inserted
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    void insertStoryPanel(StoryPanel storyPanel) throws DaoException;

    /**
     * Updates a storyPanel from the database.
     *
     * @param storyPanel - story panel to be updated
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    void updateStoryPanel(StoryPanel storyPanel) throws DaoException;

    /**
     * Deletes a storyPanel from the database.
     *
     * @param storyPanel - story panel to be deleted.
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    void deleteStoryPanel(StoryPanel storyPanel) throws DaoException;
}
