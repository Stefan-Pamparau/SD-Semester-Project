package service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import dao.RegularUserDao;
import dao.exception.DaoException;
import model.planner.user.RegularUser;
import service.RegularUserService;
import service.exception.ServiceException;

/**
 * Default implementation of the RegularUserService interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultRegularUserServiceImpl implements RegularUserService {
    @Autowired
    private RegularUserDao regularUserDao;

    @Override
    public RegularUser getRegularUser(Integer id) throws ServiceException {
        try {
            return regularUserDao.getRegularUser(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public RegularUser findRegularUserByCNP(String CNP) throws ServiceException {
        try {
            return regularUserDao.findRegularUserByCNP(CNP);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void insertRegularUser(RegularUser regularUser) throws ServiceException {
        try {
            regularUserDao.insertRegularUser(regularUser);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void updateRegularUser(RegularUser regularUser) throws ServiceException {
        try {
            regularUserDao.updateRegularUser(regularUser);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRegularUser(RegularUser regularUser) throws ServiceException {
        try {
            regularUserDao.deleteRegularUser(regularUser);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public RegularUserDao getRegularUserDao() {
        return regularUserDao;
    }

    public void setRegularUserDao(RegularUserDao regularUserDao) {
        this.regularUserDao = regularUserDao;
    }
}
