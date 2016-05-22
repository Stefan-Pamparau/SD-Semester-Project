package dao.impl;

import org.hibernate.SessionFactory;

import dao.ProjectDao;
import dao.exception.DaoException;
import model.planner.project.Project;

/**
 * Default implementation of the ProjectDao interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultProjectDaoImpl implements ProjectDao {
    private SessionFactory sessionFactory;

    public DefaultProjectDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Project getProject(Integer id) throws DaoException {
        return null;
    }

    @Override
    public void insertProject(Project project) throws DaoException {

    }

    @Override
    public void updateProject(Project project) throws DaoException {

    }

    @Override
    public void deleteProject(Project project) throws DaoException {

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
