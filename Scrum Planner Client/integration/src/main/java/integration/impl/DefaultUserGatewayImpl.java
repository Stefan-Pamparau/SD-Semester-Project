package integration.impl;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import integration.UserGateway;
import integration.exception.IntegrationException;
import model.planner.user.User;

/**
 * Default implementation of the UserGateway interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultUserGatewayImpl implements UserGateway {
    private static final String SERVER_URL = "http://localhost:8080";

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public User getUserByEmailAndPassword(String email, String password) throws IntegrationException {
        String requestUri = UriComponentsBuilder.fromUriString(SERVER_URL + "/user/get").queryParam("email", email).queryParam("password", password).toUriString();
        return restTemplate.getForObject(requestUri, User.class);
    }
}
