package integration.impl;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import integration.ProjectGateway;
import integration.exception.IntegrationException;
import model.planner.project.Project;
import model.planner.user.Employee;

/**
 * Default implementation of the ProjectGateway interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultProjectGatewayImpl implements ProjectGateway {
    private static final String SERVER_URL = "http://localhost:8080";

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public Project getProject(Integer id) throws IntegrationException {
        String requestUri = UriComponentsBuilder.fromUriString(SERVER_URL + "/project/get/{id}").buildAndExpand(id).toUriString();
        return restTemplate.getForObject(requestUri, Project.class);
    }

    @Override
    public Project insertProject(Project project) throws IntegrationException {
        HttpEntity<Project> request = new HttpEntity<>(project);
        return restTemplate.postForObject(SERVER_URL + "/project/insert", request, Project.class);
    }

    @Override
    public void updateProject(Project project) throws IntegrationException {
        HttpEntity<Project> request = new HttpEntity<>(project);
        restTemplate.put(SERVER_URL + "/project/update", request, Project.class);
    }

    @Override
    public void deleteProject(Project project) throws IntegrationException {
        String requestUri = UriComponentsBuilder.fromUriString(SERVER_URL + "/project/delete/{id}").buildAndExpand(project.getId()).toUriString();
        restTemplate.delete(requestUri);
    }
}
