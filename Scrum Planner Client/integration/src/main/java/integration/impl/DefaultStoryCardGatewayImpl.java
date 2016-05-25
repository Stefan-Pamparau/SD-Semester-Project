package integration.impl;

import integration.StoryCardGateway;
import integration.exception.IntegrationException;
import model.planner.card.StoryCard;

/**
 * Default implementation of the StoryCardGateway interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultStoryCardGatewayImpl implements StoryCardGateway {
    @Override
    public StoryCard getStoryCard(Integer id) throws IntegrationException {
        return null;
    }

    @Override
    public void insertStoryCard(StoryCard storyCard) throws IntegrationException {

    }

    @Override
    public void updateStoryCard(StoryCard storyCard) throws IntegrationException {

    }

    @Override
    public void deleteStoryCard(StoryCard storyCard) throws IntegrationException {

    }
}
