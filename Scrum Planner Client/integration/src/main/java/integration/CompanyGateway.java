package integration;

import integration.exception.IntegrationException;
import model.planner.user.Company;

/**
 * Interface declaring all methods to manipulate Company entities.
 *
 * @author Stefan Pamparau
 */
public interface CompanyGateway {
    /**
     * Returns a company based on a specified id.
     *
     * @param id - id of the company
     * @return - the company with the specified id, null if the company does not exist
     * @throws IntegrationException - thrown when a Dao exception occurs
     */
    Company getCompany(Integer id) throws IntegrationException;

    /**
     * Returns a company based on it's registration number.
     *
     * @param registrationNumber - the registration number of the company
     * @return - a company with the specified registration number, null if no company found
     * @throws IntegrationException - thrown when a Dao exception occurs
     */
    Company findCompanyByRegistrationNumber(String registrationNumber) throws IntegrationException;

    /**
     * Inserts a company into the database.
     *
     * @param company - company to be inserted
     * @throws IntegrationException - thrown when a Dao exception occurs
     */
    void insertCompany(Company company) throws IntegrationException;

    /**
     * Updates a company from the database.
     *
     * @param company - company to be updated
     * @throws IntegrationException - thrown when a Dao exception occurs
     */
    void updateCompany(Company company) throws IntegrationException;

    /**
     * Deletes a company from the database.
     *
     * @param company - company to be deleted.
     * @throws IntegrationException - thrown when a Dao exception occurs
     */
    void deleteCompany(Company company) throws IntegrationException;
}
