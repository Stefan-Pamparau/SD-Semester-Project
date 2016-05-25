package service;

import model.planner.card.Tag;
import service.exception.ServiceException;

/**
 * Interface declaring methods to manipulate Tag entities.
 *
 * @author Stefan Pamparau
 */
public interface TagService {
    /**
     * Returns a tag based on a specified id.
     *
     * @param id - id of the tag
     * @return - the tag with the specified id, null if the tag does not exist
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    Tag getTag(Integer id) throws ServiceException;

    /**
     * Inserts a tag into the database.
     *
     * @param tag - tag to be inserted
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    void insertTag(Tag tag) throws ServiceException;

    /**
     * Updates a tag from the database.
     *
     * @param tag - tag to be updated
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    void updateTag(Tag tag) throws ServiceException;

    /**
     * Deletes a tag from the database.
     *
     * @param tag - tag to be deleted.
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    void deleteTag(Tag tag) throws ServiceException;
}
