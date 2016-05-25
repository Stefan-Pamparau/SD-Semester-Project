package integration.impl;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import integration.StoryCardGateway;
import integration.exception.IntegrationException;
import model.planner.card.StoryCard;

/**
 * Default implementation of the StoryCardGateway interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultStoryCardGatewayImpl implements StoryCardGateway {
    private static final String SERVER_URL = "http://localhost:8080";

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public StoryCard getStoryCard(Integer id) throws IntegrationException {
        String requestUri = UriComponentsBuilder.fromUriString(SERVER_URL + "/storyCard/get/{id}").buildAndExpand(id).toUriString();
        return restTemplate.getForObject(requestUri, StoryCard.class);
    }

    @Override
    public void insertStoryCard(StoryCard storyCard) throws IntegrationException {
        HttpEntity<StoryCard> request = new HttpEntity<>(storyCard);
        StoryCard receivedStoryCard = restTemplate.postForObject(SERVER_URL + "/storyCard/insert", request, StoryCard.class);
    }

    @Override
    public void updateStoryCard(StoryCard storyCard) throws IntegrationException {
        HttpEntity<StoryCard> request = new HttpEntity<>(storyCard);
        restTemplate.put(SERVER_URL + "/storyCard/update", request, StoryCard.class);
    }

    @Override
    public void deleteStoryCard(StoryCard storyCard) throws IntegrationException {
        String requestUri = UriComponentsBuilder.fromUriString(SERVER_URL + "/storyCard/delete/{id}").buildAndExpand(storyCard.getId()).toUriString();
        restTemplate.delete(requestUri);
    }
}
