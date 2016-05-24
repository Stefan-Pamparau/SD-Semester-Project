package dao;

import dao.exception.DaoException;
import model.planner.user.Company;

/**
 * Dao interface which declares al the methods to manipulate company entities.
 *
 * @author Stefan Pamparau
 */
public interface CompanyDao {
    /**
     * Returns a company based on a specified id.
     *
     * @param id - id of the company
     * @return - the company with the specified id, null if the company does not exist
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    Company getCompany(Integer id) throws DaoException;

    /**
     * Inserts a company into the database.
     *
     * @param company - company to be inserted
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    void insertCompany(Company company) throws DaoException;

    /**
     * Updates a company from the database.
     *
     * @param company - company to be updated
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    void updateCompany(Company company) throws DaoException;

    /**
     * Deletes a company from the database.
     *
     * @param company - company to be deleted.
     * @throws DaoException - thrown when a Hibernate exception occurs
     */
    void deleteCompany(Company company) throws DaoException;
}
