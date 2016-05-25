package integration.impl;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import integration.TaskBoardGateway;
import integration.exception.IntegrationException;
import model.planner.taskboard.TaskBoard;

/**
 * Default implementation of the TaskBoardGateway interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultTaskBoardGatewayImpl implements TaskBoardGateway {
    private static final String SERVER_URL = "http://localhost:8080";

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public TaskBoard getTaskBoard(Integer id) throws IntegrationException {
        String requestUri = UriComponentsBuilder.fromUriString(SERVER_URL + "/taskBoard/get/{id}").buildAndExpand(id).toUriString();
        return restTemplate.getForObject(requestUri, TaskBoard.class);
    }

    @Override
    public void insertTaskBoard(TaskBoard taskBoard) throws IntegrationException {
        HttpEntity<TaskBoard> request = new HttpEntity<>(taskBoard);
        TaskBoard receivedTaskBoard = restTemplate.postForObject(SERVER_URL + "/taskBoard/insert", request, TaskBoard.class);
    }

    @Override
    public void updateTaskBoard(TaskBoard taskBoard) throws IntegrationException {
        HttpEntity<TaskBoard> request = new HttpEntity<>(taskBoard);
        restTemplate.put(SERVER_URL + "/taskBoard/update", request, TaskBoard.class);
    }

    @Override
    public void deleteTaskBoard(TaskBoard taskBoard) throws IntegrationException {
        String requestUri = UriComponentsBuilder.fromUriString(SERVER_URL + "/taskBoard/delete/{id}").buildAndExpand(taskBoard.getId()).toUriString();
        restTemplate.delete(requestUri);
    }
}
