package service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import dao.StoryCardDao;
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
        return null;
    }

    @Override
    public void insertStoryCard(StoryCard storyCard) throws ServiceException {

    }

    @Override
    public void updateStoryCard(StoryCard storyCard) throws ServiceException {

    }

    @Override
    public void deleteStoryCard(StoryCard storyCard) throws ServiceException {

    }

    public StoryCardDao getStoryCardDao() {
        return storyCardDao;
    }

    public void setStoryCardDao(StoryCardDao storyCardDao) {
        this.storyCardDao = storyCardDao;
    }
}
