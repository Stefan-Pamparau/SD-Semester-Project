package integration.impl;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import integration.ProjectManagerGateway;
import integration.exception.IntegrationException;
import model.planner.user.Employee;
import model.planner.user.ProjectManager;

/**
 * Default implementation of the ProjectManagerGateway interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultProjectManagerGatewayImpl implements ProjectManagerGateway {
    private static final String SERVER_URL = "http://localhost:8080";

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public ProjectManager getProjectManager(Integer id) throws IntegrationException {
        String requestUri = UriComponentsBuilder.fromUriString(SERVER_URL + "/projectManager/get/{id}").buildAndExpand(id).toUriString();
        return restTemplate.getForObject(requestUri, ProjectManager.class);
    }

    @Override
    public ProjectManager findProjectManagerByCNP(String CNP) throws IntegrationException {
        String requestUri = UriComponentsBuilder.fromUriString(SERVER_URL + "/projectManager/get").queryParam("CNP", CNP).toUriString();
        return restTemplate.getForObject(requestUri, ProjectManager.class);
    }

    @Override
    public void insertProjectManager(ProjectManager projectManager) throws IntegrationException {
        HttpEntity<Employee> request = new HttpEntity<>(projectManager);
        ProjectManager receivedProjectManager = restTemplate.postForObject(SERVER_URL + "/projectManager/insert", request, ProjectManager.class);
    }

    @Override
    public void updateProjectManager(ProjectManager projectManager) throws IntegrationException {
        HttpEntity<ProjectManager> request = new HttpEntity<>(projectManager);
        restTemplate.put(SERVER_URL + "/projectManager/update", request, ProjectManager.class);
    }

    @Override
    public void deleteProjectManager(ProjectManager projectManager) throws IntegrationException {
        String requestUri = UriComponentsBuilder.fromUriString(SERVER_URL + "/projectManager/delete/{id}").buildAndExpand(projectManager.getId()).toUriString();
        restTemplate.delete(requestUri);
    }
}
