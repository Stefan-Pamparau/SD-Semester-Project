package dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public Project getProject(Integer id) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Project.class, id);
        } catch (HibernateException e) {
            throw new DaoException("Cannot retrieve project with id:" + id, e);
        }
    }

    @Override
    @Transactional
    public void insertProject(Project project) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            session.save(project);
            session.flush();
        } catch (HibernateException e) {
            throw new DaoException("Cannot insert project", e);
        }
    }

    @Override
    @Transactional
    public void updateProject(Project project) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            Project persistentProject = session.get(Project.class, project.getId());

            if (persistentProject != null) {
                persistentProject.setName(project.getName());
                persistentProject.setPermissionType(project.getPermissionType());
                persistentProject.setUsers(project.getUsers());
                session.update(persistentProject);
                session.flush();
            }
        } catch (HibernateException e) {
            throw new DaoException("Cannot update project", e);
        }
    }

    @Override
    @Transactional
    public void deleteProject(Project project) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            Project persistentProject = session.get(Project.class, project.getId());

            if (persistentProject != null) {
                session.delete(persistentProject);
                session.flush();
            }
        } catch (HibernateException e) {
            throw new DaoException("Cannot delete project", e);
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
