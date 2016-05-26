package dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import dao.TagDao;
import dao.exception.DaoException;
import model.planner.card.Tag;

/**
 * Default implementation of the TagDao interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultTagDaoImpl implements TagDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Tag getTag(Integer id) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Tag.class, id);
        } catch (HibernateException e) {
            throw new DaoException("Cannot get tag with id:" + id, e);
        }
    }

    @Override
    @Transactional
    public void insertTag(Tag tag) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            session.save(tag);
            session.flush();
        } catch (HibernateException e) {
            throw new DaoException("Cannot insert tag", e);
        }
    }

    @Override
    @Transactional
    public void updateTag(Tag tag) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            Tag persistentTag = session.get(Tag.class, tag.getId());

            if (persistentTag != null) {
                persistentTag.setDescription(tag.getDescription());
//                persistentTag.setTaskCard(tag.getTaskCard());
                session.update(tag);
                session.flush();
            }
        } catch (HibernateException e) {
            throw new DaoException("Cannot update tag", e);
        }
    }

    @Override
    @Transactional
    public void deleteTag(Tag tag) throws DaoException {
        try (Session session = sessionFactory.openSession()) {
            Tag persistentTag = session.get(Tag.class, tag.getId());

            if (persistentTag != null) {
                session.delete(tag);
                session.flush();
            }
        } catch (HibernateException e) {
            throw new DaoException("Cannot delete tag", e);
        }
    }
}
