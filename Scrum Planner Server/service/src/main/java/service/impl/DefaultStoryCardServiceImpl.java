package service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import dao.StoryCardDao;
import dao.exception.DaoException;
import model.planner.card.StoryCard;
import service.StoryCardService;
import service.exception.ServiceException;

/**
 * Default implementation of the StoryCardService interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultStoryCardServiceImpl implements StoryCardService {
    @Autowired
    private StoryCardDao storyCardDao;

    @Override
    public StoryCard getStoryCard(Integer id) throws ServiceException {
        try {
            return storyCardDao.getStoryCard(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void insertStoryCard(StoryCard storyCard) throws ServiceException {
        try {
            storyCardDao.insertStoryCard(storyCard);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void updateStoryCard(StoryCard storyCard) throws ServiceException {
        try {
            storyCardDao.updateStoryCard(storyCard);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void deleteStoryCard(StoryCard storyCard) throws ServiceException {
        try {
            storyCardDao.deleteStoryCard(storyCard);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public StoryCardDao getStoryCardDao() {
        return storyCardDao;
    }

    public void setStoryCardDao(StoryCardDao storyCardDao) {
        this.storyCardDao = storyCardDao;
    }
}
