package integration.impl;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import integration.RegularUserGateway;
import integration.exception.IntegrationException;
import model.planner.user.RegularUser;

/**
 * Default implementation of the RegularUserGateway interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultRegularUserGatewayImpl implements RegularUserGateway {
    private static final String SERVER_URL = "http://localhost:8080";

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public RegularUser getRegularUser(Integer id) throws IntegrationException {
        String requestUri = UriComponentsBuilder.fromUriString(SERVER_URL + "/regularUser/get/{id}").buildAndExpand(id).toUriString();
        return restTemplate.getForObject(requestUri, RegularUser.class);
    }

    @Override
    public RegularUser findRegularUserByCNP(String CNP) throws IntegrationException {
        String requestUri = UriComponentsBuilder.fromUriString(SERVER_URL + "/regularUser/get").queryParam("CNP", CNP).toUriString();
        return restTemplate.getForObject(requestUri, RegularUser.class);
    }

    @Override
    public RegularUser insertRegularUser(RegularUser regularUser) throws IntegrationException {
        HttpEntity<RegularUser> request = new HttpEntity<>(regularUser);
        return restTemplate.postForObject(SERVER_URL + "/regularUser/insert", request, RegularUser.class);
    }

    @Override
    public void updateRegularUser(RegularUser regularUser) throws IntegrationException {
        HttpEntity<RegularUser> request = new HttpEntity<>(regularUser);
        restTemplate.put(SERVER_URL + "/regularUser/update", request, RegularUser.class);
    }

    @Override
    public void deleteRegularUser(RegularUser regularUser) throws IntegrationException {
        String requestUri = UriComponentsBuilder.fromUriString(SERVER_URL + "/regularUser/delete/{id}").buildAndExpand(regularUser.getId()).toUriString();
        restTemplate.delete(requestUri);
    }
}
