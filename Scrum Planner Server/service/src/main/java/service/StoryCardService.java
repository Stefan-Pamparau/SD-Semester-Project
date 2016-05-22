package service;

import model.planner.card.StoryCard;
import service.exception.ServiceException;

/**
 * Interface which declares methods to manipulate story card entities.
 *
 * @author Stefan Pamparau
 */
public interface StoryCardService {
    /**
     * Returns a story card based on a specified id.
     *
     * @param id - id of the pstoryCard
     * @return - the story card with the specified id, null if the pstoryCard does not exist
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    StoryCard getStoryCard(Integer id) throws ServiceException;

    /**
     * Inserts a storyCard into the database.
     *
     * @param storyCard - story card to be inserted
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    void insertStoryCard(StoryCard storyCard) throws ServiceException;

    /**
     * Updates a storyCard from the database.
     *
     * @param storyCard - story card to be updated
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    void updateStoryCard(StoryCard storyCard) throws ServiceException;

    /**
     * Deletes a storyCard from the database.
     *
     * @param storyCard - story card to be deleted.
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    void deleteStoryCard(StoryCard storyCard) throws ServiceException;
}
