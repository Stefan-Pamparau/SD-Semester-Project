package service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import dao.TagDao;
import dao.exception.DaoException;
import model.planner.card.Tag;
import service.TagService;
import service.exception.ServiceException;

/**
 * Default implementation of the TagService interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultTagServiceImpl implements TagService {
    @Autowired
    private TagDao tagDao;

    @Override
    public Tag getTag(Integer id) throws ServiceException {
        try {
            return tagDao.getTag(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void insertTag(Tag tag) throws ServiceException {
        try {
            tagDao.insertTag(tag);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void updateTag(Tag tag) throws ServiceException {
        try {
            tagDao.updateTag(tag);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void deleteTag(Tag tag) throws ServiceException {
        try {
            tagDao.deleteTag(tag);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
