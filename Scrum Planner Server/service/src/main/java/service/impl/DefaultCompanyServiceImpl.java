package service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import dao.CompanyDao;
import model.planner.user.Company;
import service.CompanyService;
import service.exception.ServiceException;

/**
 * Default implementation of the CompanyService interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultCompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyDao companyDao;

    @Override
    public Company getCompany(Integer id) throws ServiceException {
        return null;
    }

    @Override
    public Company getCompanyByRegistrationNumber(String registrationNumber) throws ServiceException {
        return null;
    }

    @Override
    public void insertCompany(Company company) throws ServiceException {

    }

    @Override
    public void updateCompany(Company company) throws ServiceException {

    }

    @Override
    public void deleteCompany(Company company) throws ServiceException {

    }

    public CompanyDao getCompanyDao() {
        return companyDao;
    }

    public void setCompanyDao(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }
}
