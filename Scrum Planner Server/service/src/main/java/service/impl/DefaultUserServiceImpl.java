package service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import dao.UserDao;
import model.user.User;
import service.UserService;
import service.exception.ServiceException;

/**
 * Default implementation of the UserService interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultUserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByEmailAndPassword(String email, String password) throws ServiceException {
        return null;
    }
}
