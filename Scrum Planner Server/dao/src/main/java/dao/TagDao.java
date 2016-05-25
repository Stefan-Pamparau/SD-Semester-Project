package dao;

import dao.exception.DaoException;
import model.planner.card.Tag;

/**
 * Interface declaring methods to manipulate Tag entities.
 *
 * @author Stefan Pamparau
 */
public interface TagDao {
    /**
     * Returns a tag based on a specified id.
     *
     * @param id - id of the tag
     * @return - the tag with the specified id, null if the tag does not exist
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    Tag getTag(Integer id) throws DaoException;

    /**
     * Inserts a tag into the database.
     *
     * @param tag - tag to be inserted
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    void insertTag(Tag tag) throws DaoException;

    /**
     * Updates a tag from the database.
     *
     * @param tag - tag to be updated
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    void updateTag(Tag tag) throws DaoException;

    /**
     * Deletes a tag from the database.
     *
     * @param tag - tag to be deleted.
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    void deleteTag(Tag tag) throws DaoException;
}
