package dao;

import dao.exception.DaoException;
import model.planner.card.StoryCard;

/**
 * Interface which declares methods to manipulate story card entities.
 *
 * @author Stefan Pamparau
 */
public interface StoryCardDao {
    /**
     * Returns a story card based on a specified id.
     *
     * @param id - id of the pstoryCard
     * @return - the story card with the specified id, null if the pstoryCard does not exist
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    StoryCard getStoryCard(Integer id) throws DaoException;

    /**
     * Inserts a pstoryCard into the database.
     *
     * @param storyCard - story card to be inserted
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    void insertStoryCard(StoryCard storyCard) throws DaoException;

    /**
     * Updates a pstoryCard from the database.
     *
     * @param storyCard - story card to be updated
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    void updateStoryCard(StoryCard storyCard) throws DaoException;

    /**
     * Deletes a pstoryCard from the database.
     *
     * @param storyCard - story card to be deleted.
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    void deleteStoryCard(StoryCard storyCard) throws DaoException;
}
