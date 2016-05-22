package service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import dao.RegularUserDao;
import model.user.RegularUser;
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
        return null;
    }

    @Override
    public void insertRegularUser(RegularUser regularUser) throws ServiceException {

    }

    @Override
    public void updateRegularUser(RegularUser regularUser) throws ServiceException {

    }

    @Override
    public void deleteRegularUser(RegularUser regularUser) throws ServiceException {

    }

    public RegularUserDao getRegularUserDao() {
        return regularUserDao;
    }

    public void setRegularUserDao(RegularUserDao regularUserDao) {
        this.regularUserDao = regularUserDao;
    }
}
