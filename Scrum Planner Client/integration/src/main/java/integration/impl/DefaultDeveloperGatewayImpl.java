package integration.impl;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import integration.DeveloperGateway;
import integration.exception.IntegrationException;
import model.planner.user.Developer;

/**
 * Default implementation of the DeveloperGateway interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultDeveloperGatewayImpl implements DeveloperGateway {
    private static final String SERVER_URL = "http://localhost:8080";

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public Developer getDeveloper(Integer id) throws IntegrationException {
        String requestUri = UriComponentsBuilder.fromUriString(SERVER_URL + "/developer/get/{id}").buildAndExpand(id).toUriString();
        return restTemplate.getForObject(requestUri, Developer.class);
    }

    @Override
    public Developer findDeveloperByCNP(String CNP) throws IntegrationException {
        String requestUri = UriComponentsBuilder.fromUriString(SERVER_URL + "/developer/get").queryParam("CNP", CNP).toUriString();
        return restTemplate.getForObject(requestUri, Developer.class);
    }

    @Override
    public Developer insertDeveloper(Developer developer) throws IntegrationException {
        HttpEntity<Developer> request = new HttpEntity<>(developer);
        return restTemplate.postForObject(SERVER_URL + "/developer/insert", request, Developer.class);
    }

    @Override
    public void updateDeveloper(Developer developer) throws IntegrationException {
        HttpEntity<Developer> request = new HttpEntity<>(developer);
        restTemplate.put(SERVER_URL + "/developer/update", request, Developer.class);
    }

    @Override
    public void deleteDeveloper(Developer developer) throws IntegrationException {
        String requestUri = UriComponentsBuilder.fromUriString(SERVER_URL + "/developer/delete/{id}").buildAndExpand(developer.getId()).toUriString();
        restTemplate.delete(requestUri);
    }
}
