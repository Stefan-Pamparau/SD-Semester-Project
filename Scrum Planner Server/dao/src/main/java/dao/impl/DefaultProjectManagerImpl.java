package dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import dao.ProjectManagerDao;
import dao.exception.DaoException;
import model.planner.user.ProjectManager;

/**
 * Default implementation of the ProjectManagerDao interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultProjectManagerImpl implements ProjectManagerDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public ProjectManager getProjectManager(Integer id) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            return session.get(ProjectManager.class, id);
        } catch (HibernateException e) {
            throw new DaoException("Cannot get project manager with id:" + id, e);
        }
    }

    @Override
    @Transactional
    public ProjectManager findProjectManagerByCNP(String CNP) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            List projectManager = session.createQuery("FROM model.planner.user.ProjectManager projectManager WHERE projectManager.CNP = :CNP")
                    .setParameter("CNP", CNP)
                    .list();

            if (projectManager != null && projectManager.size() == 1) {
                return (ProjectManager) projectManager.get(0);
            } else {
                return null;
            }
        } catch (HibernateException e) {
            throw new DaoException("Cannot retrieve project manager with CNP:" + CNP, e);
        }
    }

    @Override
    @Transactional
    public void insertProjectManager(ProjectManager projectManager) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            if (findProjectManagerByCNP(projectManager.getCNP()) == null) {
                session.save(projectManager);
                session.flush();
            }
        } catch (HibernateException e) {
            throw new DaoException("Cannot insert project manager", e);
        }
    }

    @Override
    @Transactional
    public void updateProjectManager(ProjectManager projectManager) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            ProjectManager persistentProjectManager = findProjectManagerByCNP(projectManager.getCNP());

            if (persistentProjectManager != null) {
                persistentProjectManager.setName(projectManager.getName());
                persistentProjectManager.setEmail(projectManager.getEmail());
                persistentProjectManager.setAge(projectManager.getAge());
                persistentProjectManager.setPassword(projectManager.getPassword());
                persistentProjectManager.setProjects(projectManager.getProjects());
                persistentProjectManager.setDevelopers(projectManager.getDevelopers());
                session.update(persistentProjectManager);
                session.flush();
            }
        } catch (HibernateException e) {
            throw new DaoException("Cannot update project manager", e);
        }
    }

    @Override
    @Transactional
    public void deleteProjectManager(ProjectManager projectManager) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            ProjectManager persistentProjectManager = findProjectManagerByCNP(projectManager.getCNP());

            if (persistentProjectManager != null) {
                session.delete(persistentProjectManager);
                session.flush();
            }
        } catch (HibernateException e) {
            throw new DaoException("Cannot delete project manager", e);
        }
    }
}
