package service.impl;

import org.springframework.beans.factory.annotation.Autowired;

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
    private StoryPanelService storyPanelService;

    @Override
    public StoryPanel getStoryPanel(Integer id) throws ServiceException {
        return null;
    }

    @Override
    public void insertStoryPanel(StoryPanel storyPanel) throws ServiceException {

    }

    @Override
    public void updateStoryPanel(StoryPanel storyPanel) throws ServiceException {

    }

    @Override
    public void deleteStoryPanel(StoryPanel storyPanel) throws ServiceException {

    }

    public StoryPanelService getStoryPanelService() {
        return storyPanelService;
    }

    public void setStoryPanelService(StoryPanelService storyPanelService) {
        this.storyPanelService = storyPanelService;
    }
}
