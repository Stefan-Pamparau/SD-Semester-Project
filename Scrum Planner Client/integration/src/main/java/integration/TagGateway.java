package integration;

import integration.exception.IntegrationException;
import model.planner.card.Tag;

/**
 * Interface declaring methods to manipulate Tag entities.
 *
 * @author Stefan Pamparau
 */
public interface TagGateway {
    /**
     * Returns a tag based on a specified id.
     *
     * @param id - id of the tag
     * @return - the tag with the specified id, null if the tag does not exist
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    Tag getTag(Integer id) throws IntegrationException;

    /**
     * Inserts a tag into the database.
     *
     * @param tag - tag to be inserted
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    Tag insertTag(Tag tag) throws IntegrationException;

    /**
     * Updates a tag from the database.
     *
     * @param tag - tag to be updated
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    void updateTag(Tag tag) throws IntegrationException;

    /**
     * Deletes a tag from the database.
     *
     * @param tag - tag to be deleted.
     * @throws IntegrationException - thrown when a Server exception occurs
     */
    void deleteTag(Tag tag) throws IntegrationException;
}
