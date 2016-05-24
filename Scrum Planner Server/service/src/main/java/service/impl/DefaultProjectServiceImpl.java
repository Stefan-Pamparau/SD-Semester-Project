package service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import dao.ProjectDao;
import dao.exception.DaoException;
import model.planner.project.Project;
import service.ProjectService;
import service.exception.ServiceException;

/**
 * Default implementation of the ProjectService interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectDao projectDao;

    @Override
    public Project getProject(Integer id) throws ServiceException {
        try {
            return projectDao.getProject(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void insertProject(Project project) throws ServiceException {
        try {
            projectDao.insertProject(project);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void updateProject(Project project) throws ServiceException {
        try {
            projectDao.updateProject(project);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void deleteProject(Project project) throws ServiceException {
        try {
            projectDao.deleteProject(project);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public ProjectDao getProjectDao() {
        return projectDao;
    }

    public void setProjectDao(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }
}
