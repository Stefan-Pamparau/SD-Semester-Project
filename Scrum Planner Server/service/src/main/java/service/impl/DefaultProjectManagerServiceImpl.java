package service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import dao.ProjectManagerDao;
import dao.exception.DaoException;
import model.planner.user.ProjectManager;
import service.ProjectManagerService;
import service.exception.ServiceException;

/**
 * Default implementation of the ProjectManagerService interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultProjectManagerServiceImpl implements ProjectManagerService {
    @Autowired
    private ProjectManagerDao projectManagerDao;

    @Override
    public ProjectManager getProjectManager(Integer id) throws ServiceException {
        try {
            return projectManagerDao.getProjectManager(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public ProjectManager findProjectManagerByCNP(String CNP) throws ServiceException {
        try {
            return projectManagerDao.findProjectManagerByCNP(CNP);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void insertProjectManager(ProjectManager projectManager) throws ServiceException {
        try {
            projectManagerDao.insertProjectManager(projectManager);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void updateProjectManager(ProjectManager projectManager) throws ServiceException {
        try {
            projectManagerDao.updateProjectManager(projectManager);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void deleteProjectManager(ProjectManager projectManager) throws ServiceException {
        try {
            projectManagerDao.deleteProjectManager(projectManager);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
