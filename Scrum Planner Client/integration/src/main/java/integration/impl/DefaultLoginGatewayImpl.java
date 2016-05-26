package integration.impl;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import integration.LoginGateway;
import integration.exception.IntegrationException;
import model.planner.user.User;

/**
 * Default implementation of the LoginGateway interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultLoginGatewayImpl implements LoginGateway {
    private static final String SERVER_URL = "http://localhost:8080";

    private RestTemplate restTemplate = new RestTemplate();
    private User currentlyLoggedUser;

    @Override
    public User getUserByEmailAndPassword(String email, String password) throws IntegrationException {
        String requestUri = UriComponentsBuilder.fromUriString(SERVER_URL + "/user/get").queryParam("email", email).queryParam("password", password).toUriString();
        User user = restTemplate.getForObject(requestUri, User.class);
        currentlyLoggedUser = user;
        return user;
    }

    @Override
    public User getCurrentlyLoggedUser() {
        return currentlyLoggedUser;
    }
}
