package service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import dao.ProjectDao;
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
        return null;
    }

    @Override
    public void insertProject(Project project) throws ServiceException {

    }

    @Override
    public void updateProject(Project project) throws ServiceException {

    }

    @Override
    public void deleteProject(Project project) throws ServiceException {

    }

    public ProjectDao getProjectDao() {
        return projectDao;
    }

    public void setProjectDao(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }
}
