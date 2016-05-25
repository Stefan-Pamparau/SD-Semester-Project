package integration.impl;

import integration.StoryPanelGateway;
import integration.exception.IntegrationException;
import model.planner.taskboard.StoryPanel;

/**
 * Default implementation of the StoryPanelGateway interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultStoryPanelGatewayImpl implements StoryPanelGateway {
    @Override
    public StoryPanel getStoryPanel(Integer id) throws IntegrationException {
        return null;
    }

    @Override
    public void insertStoryPanel(StoryPanel storyPanel) throws IntegrationException {

    }

    @Override
    public void updateStoryPanel(StoryPanel storyPanel) throws IntegrationException {

    }

    @Override
    public void deleteStoryPanel(StoryPanel storyPanel) throws IntegrationException {

    }
}
