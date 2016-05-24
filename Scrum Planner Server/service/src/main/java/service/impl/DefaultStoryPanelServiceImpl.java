package service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import dao.StoryPanelDao;
import dao.exception.DaoException;
import model.planner.taskboard.StoryPanel;
import service.StoryPanelService;
import service.exception.ServiceException;

/**
 * Default implementation of the StoryPanelService interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultStoryPanelServiceImpl implements StoryPanelService {
    @Autowired
    private StoryPanelDao storyPanelDao;

    @Override
    public StoryPanel getStoryPanel(Integer id) throws ServiceException {
        try {
            return storyPanelDao.getStoryPanel(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void insertStoryPanel(StoryPanel storyPanel) throws ServiceException {
        try {
            storyPanelDao.insertStoryPanel(storyPanel);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void updateStoryPanel(StoryPanel storyPanel) throws ServiceException {
        try {
            storyPanelDao.updateStoryPanel(storyPanel);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void deleteStoryPanel(StoryPanel storyPanel) throws ServiceException {
        try {
            storyPanelDao.deleteStoryPanel(storyPanel);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public StoryPanelDao getStoryPanelDao() {
        return storyPanelDao;
    }

    public void setStoryPanelDao(StoryPanelDao storyPanelDao) {
        this.storyPanelDao = storyPanelDao;
    }
}
