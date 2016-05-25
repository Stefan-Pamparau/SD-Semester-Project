package integration.impl;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import integration.StoryPanelGateway;
import integration.exception.IntegrationException;
import model.planner.card.StoryCard;
import model.planner.taskboard.StoryPanel;

/**
 * Default implementation of the StoryPanelGateway interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultStoryPanelGatewayImpl implements StoryPanelGateway {
    private static final String SERVER_URL = "http://localhost:8080";

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public StoryPanel getStoryPanel(Integer id) throws IntegrationException {
        String requestUri = UriComponentsBuilder.fromUriString(SERVER_URL + "/storyPanel/get/{id}").buildAndExpand(id).toUriString();
        return restTemplate.getForObject(requestUri, StoryPanel.class);
    }

    @Override
    public void insertStoryPanel(StoryPanel storyPanel) throws IntegrationException {
        HttpEntity<StoryPanel> request = new HttpEntity<>(storyPanel);
        StoryPanel receivedStoryPanel = restTemplate.postForObject(SERVER_URL + "/storyPanel/insert", request, StoryPanel.class);
    }

    @Override
    public void updateStoryPanel(StoryPanel storyPanel) throws IntegrationException {
        HttpEntity<StoryPanel> request = new HttpEntity<>(storyPanel);
        restTemplate.put(SERVER_URL + "/storyPanel/update", request, StoryCard.class);
    }

    @Override
    public void deleteStoryPanel(StoryPanel storyPanel) throws IntegrationException {
        String requestUri = UriComponentsBuilder.fromUriString(SERVER_URL + "/storyPanel/delete/{id}").buildAndExpand(storyPanel.getId()).toUriString();
        restTemplate.delete(requestUri);
    }
}
