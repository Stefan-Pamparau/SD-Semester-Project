package integration.impl;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import integration.TaskPanelGateway;
import integration.exception.IntegrationException;
import model.planner.taskboard.TaskPanel;

/**
 * Default implementation of the TaskPanelGateway interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultTaskPanelGatewayImpl implements TaskPanelGateway {
    private static final String SERVER_URL = "http://localhost:8080";

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public TaskPanel getTaskPanel(Integer id) throws IntegrationException {
        String requestUri = UriComponentsBuilder.fromUriString(SERVER_URL + "/taskPanel/get/{id}").buildAndExpand(id).toUriString();
        return restTemplate.getForObject(requestUri, TaskPanel.class);
    }

    @Override
    public TaskPanel insertTaskPanel(TaskPanel taskPanel) throws IntegrationException {
        HttpEntity<TaskPanel> request = new HttpEntity<>(taskPanel);
        return restTemplate.postForObject(SERVER_URL + "/taskPanel/insert", request, TaskPanel.class);
    }

    @Override
    public void updateTaskPanel(TaskPanel taskPanel) throws IntegrationException {
        HttpEntity<TaskPanel> request = new HttpEntity<>(taskPanel);
        restTemplate.put(SERVER_URL + "/taskPanel/update", request, TaskPanel.class);
    }

    @Override
    public void deleteTaskPanel(TaskPanel taskPanel) throws IntegrationException {
        String requestUri = UriComponentsBuilder.fromUriString(SERVER_URL + "/taskPanel/delete/{id}").buildAndExpand(taskPanel.getId()).toUriString();
        restTemplate.delete(requestUri);
    }
}
