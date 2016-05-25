package integration.impl;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import integration.TaskCardGateway;
import integration.exception.IntegrationException;
import model.planner.card.TaskCard;

/**
 * Default implementation of the TaskCardGateway interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultTaskCardGatewayImpl implements TaskCardGateway {
    private static final String SERVER_URL = "http://localhost:8080";

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public TaskCard getTaskCard(Integer id) throws IntegrationException {
        String requestUri = UriComponentsBuilder.fromUriString(SERVER_URL + "/taskCard/get/{id}").buildAndExpand(id).toUriString();
        return restTemplate.getForObject(requestUri, TaskCard.class);
    }

    @Override
    public TaskCard insertTaskCard(TaskCard taskCard) throws IntegrationException {
        HttpEntity<TaskCard> request = new HttpEntity<>(taskCard);
        return restTemplate.postForObject(SERVER_URL + "/taskCard/insert", request, TaskCard.class);
    }

    @Override
    public void updateTaskCard(TaskCard taskCard) throws IntegrationException {
        HttpEntity<TaskCard> request = new HttpEntity<>(taskCard);
        restTemplate.put(SERVER_URL + "/taskCard/update", request, TaskCard.class);
    }

    @Override
    public void deleteTaskCard(TaskCard taskCard) throws IntegrationException {
        String requestUri = UriComponentsBuilder.fromUriString(SERVER_URL + "/taskCard/delete/{id}").buildAndExpand(taskCard.getId()).toUriString();
        restTemplate.delete(requestUri);
    }
}
