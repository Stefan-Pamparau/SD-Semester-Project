package service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import dao.CompanyDao;
import dao.exception.DaoException;
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
        try {
            return companyDao.getCompany(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Company findCompanyByRegistrationNumber(String registrationNumber) throws ServiceException {
        try {
            return companyDao.findCompanyByRegistrationNumber(registrationNumber);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void insertCompany(Company company) throws ServiceException {
        try {
            companyDao.insertCompany(company);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void updateCompany(Company company) throws ServiceException {
        try {
            companyDao.updateCompany(company);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void deleteCompany(Company company) throws ServiceException {
        try {
            companyDao.deleteCompany(company);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public CompanyDao getCompanyDao() {
        return companyDao;
    }

    public void setCompanyDao(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }
}
