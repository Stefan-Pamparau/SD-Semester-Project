package dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import dao.RegularUserDao;
import dao.exception.DaoException;
import model.planner.user.RegularUser;

/**
 * Default implementation of the RegularUserDao interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultRegularUserDaoImpl implements RegularUserDao {
    private SessionFactory sessionFactory;

    public DefaultRegularUserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public RegularUser getRegularUser(Integer id) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            return session.get(RegularUser.class, id);
        } catch (HibernateException e) {
            throw new DaoException("Cannot retrieve regular user with id:" + id, e);
        }
    }

    @Override
    @Transactional
    public RegularUser findRegularUserByCNP(String CNP) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            List regularUser = session.createQuery("FROM model.planner.user.RegularUser regularUser WHERE regularUser.CNP = :CNP")
                    .setParameter("CNP", CNP)
                    .list();

            if (regularUser != null && regularUser.size() == 1) {
                return (RegularUser) regularUser.get(0);
            } else {
                return null;
            }
        } catch (HibernateException e) {
            throw new DaoException("Cannot retrieve regular user with CNP:" + CNP, e);
        }
    }

    @Override
    @Transactional
    public void insertRegularUser(RegularUser regularUser) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            if (findRegularUserByCNP(regularUser.getCNP()) == null) {
                session.save(regularUser);
                session.flush();
            }
        } catch (HibernateException e) {
            throw new DaoException("Cannot insert regular user", e);
        }
    }

    @Override
    @Transactional
    public void updateRegularUser(RegularUser regularUser) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            RegularUser persistentRegularUser = findRegularUserByCNP(regularUser.getCNP());
            if (persistentRegularUser != null) {
                persistentRegularUser.setName(regularUser.getName());
                persistentRegularUser.setEmail(regularUser.getEmail());
                persistentRegularUser.setAge(regularUser.getAge());
                persistentRegularUser.setPassword(regularUser.getPassword());
                persistentRegularUser.setProjects(regularUser.getProjects());
                session.update(persistentRegularUser);
                session.flush();
            }
        } catch (HibernateException e) {
            throw new DaoException("Cannot update regular user", e);
        }
    }

    @Override
    @Transactional
    public void deleteRegularUser(RegularUser regularUser) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            RegularUser persistentRegularUser = findRegularUserByCNP(regularUser.getCNP());
            if (persistentRegularUser != null) {
                session.delete(persistentRegularUser);
                session.flush();
            }
        } catch (HibernateException e) {
            throw new DaoException("Cannot delete regular user", e);
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
