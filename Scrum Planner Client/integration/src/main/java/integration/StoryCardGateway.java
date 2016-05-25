package integration;

import integration.exception.IntegrationException;
import model.planner.card.StoryCard;

/**
 * Interface which declares methods to manipulate story card entities.
 *
 * @author Stefan Pamparau
 */
public interface StoryCardGateway {
    /**
     * Returns a story card based on a specified id.
     *
     * @param id - id of the pstoryCard
     * @return - the story card with the specified id, null if the pstoryCard does not exist
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    StoryCard getStoryCard(Integer id) throws IntegrationException;

    /**
     * Inserts a storyCard into the database.
     *
     * @param storyCard - story card to be inserted
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    void insertStoryCard(StoryCard storyCard) throws IntegrationException;

    /**
     * Updates a storyCard from the database.
     *
     * @param storyCard - story card to be updated
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    void updateStoryCard(StoryCard storyCard) throws IntegrationException;

    /**
     * Deletes a storyCard from the database.
     *
     * @param storyCard - story card to be deleted.
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    void deleteStoryCard(StoryCard storyCard) throws IntegrationException;
}
