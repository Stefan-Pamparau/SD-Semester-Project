package service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import dao.DeveloperDao;
import dao.exception.DaoException;
import model.planner.user.Developer;
import service.DeveloperService;
import service.exception.ServiceException;

/**
 * Default implementation of the DeveloperService interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultDeveloperServiceImpl implements DeveloperService {
    @Autowired
    private DeveloperDao developerDao;

    @Override
    public Developer getDeveloper(Integer id) throws ServiceException {
        try {
            return developerDao.getDeveloper(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Developer findDeveloperByCNP(String CNP) throws ServiceException {
        try {
            return developerDao.findDeveloperByCNP(CNP);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void insertDeveloper(Developer developer) throws ServiceException {
        try {
            developerDao.insertDeveloper(developer);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void updateDeveloper(Developer developer) throws ServiceException {
        try {
            developerDao.updateDeveloper(developer);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void deleteDeveloper(Developer developer) throws ServiceException {
        try {
            developerDao.deleteDeveloper(developer);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
