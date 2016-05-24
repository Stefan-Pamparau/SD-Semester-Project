package service;

import model.planner.user.Company;
import service.exception.ServiceException;

/**
 * Service interface which declares al the methods to manipulate company entities.
 *
 * @author Stefan Pamparau
 */
public interface CompanyService {
    /**
     * Returns a company based on a specified id.
     *
     * @param id - id of the company
     * @return - the company with the specified id, null if the company does not exist
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    Company getCompany(Integer id) throws ServiceException;

    /**
     * Returns a company based on it's registration number.
     *
     * @param registrationNumber - the registration number of the company
     * @return - a company with the specified registration number, null if no company found
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    Company getCompanyByRegistrationNumber(String registrationNumber) throws ServiceException;

    /**
     * Inserts a company into the database.
     *
     * @param company - company to be inserted
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    void insertCompany(Company company) throws ServiceException;

    /**
     * Updates a company from the database.
     *
     * @param company - company to be updated
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    void updateCompany(Company company) throws ServiceException;

    /**
     * Deletes a company from the database.
     *
     * @param company - company to be deleted.
     * @throws ServiceException - thrown when a Dao exception occurs
     */
    void deleteCompany(Company company) throws ServiceException;
}
