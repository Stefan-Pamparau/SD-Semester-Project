package dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import dao.DeveloperDao;
import dao.exception.DaoException;
import model.planner.user.Developer;

/**
 * Default implementation of the DeveloperDao interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultDeveloperDaoImpl implements DeveloperDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Developer getDeveloper(Integer id) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Developer.class, id);
        } catch (HibernateException e) {
            throw new DaoException("Cannot get developer with id:" + id, e);
        }
    }

    @Override
    @Transactional
    public Developer findDeveloperByCNP(String CNP) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            List developer = session.createQuery("FROM model.planner.user.Developer developer WHERE developer.CNP = :CNP")
                    .setParameter("CNP", CNP)
                    .list();

            if (developer != null && developer.size() == 1) {
                return (Developer) developer.get(0);
            } else {
                return null;
            }
        } catch (HibernateException e) {
            throw new DaoException("Cannot retrieve developer with CNP:" + CNP, e);
        }
    }

    @Override
    @Transactional
    public void insertDeveloper(Developer developer) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            if (findDeveloperByCNP(developer.getCNP()) == null) {
                session.save(developer);
                session.flush();
            }
        } catch (HibernateException e) {
            throw new DaoException("Cannot insert developer", e);
        }
    }

    @Override
    @Transactional
    public void updateDeveloper(Developer developer) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            Developer persistentDeveloper = findDeveloperByCNP(developer.getCNP());

            if (persistentDeveloper != null) {
                persistentDeveloper.setName(developer.getName());
                persistentDeveloper.setEmail(developer.getEmail());
                persistentDeveloper.setAge(developer.getAge());
                persistentDeveloper.setPassword(developer.getPassword());
                persistentDeveloper.setProjects(developer.getProjects());
//                persistentDeveloper.setProjectManager(developer.getProjectManager());
                session.update(persistentDeveloper);
                session.flush();
            }
        } catch (HibernateException e) {
            throw new DaoException("Cannot update developer", e);
        }
    }

    @Override
    @Transactional
    public void deleteDeveloper(Developer developer) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            Developer persistentDeveloper = findDeveloperByCNP(developer.getCNP());

            if (persistentDeveloper != null) {
                session.delete(persistentDeveloper);
                session.flush();
            }
        } catch (HibernateException e) {
            throw new DaoException("Cannot delete developer", e);
        }
    }
}
