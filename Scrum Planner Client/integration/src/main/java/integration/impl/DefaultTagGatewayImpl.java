package integration.impl;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import integration.TagGateway;
import integration.exception.IntegrationException;
import model.planner.card.Tag;

/**
 * Default implementation of the TagGateway interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultTagGatewayImpl implements TagGateway {
    private static final String SERVER_URL = "http://localhost:8080";

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public Tag getTag(Integer id) throws IntegrationException {
        String requestUri = UriComponentsBuilder.fromUriString(SERVER_URL + "/tag/get/{id}").buildAndExpand(id).toUriString();
        return restTemplate.getForObject(requestUri, Tag.class);
    }

    @Override
    public Tag insertTag(Tag tag) throws IntegrationException {
        HttpEntity<Tag> request = new HttpEntity<>(tag);
        return restTemplate.postForObject(SERVER_URL + "/tag/insert", request, Tag.class);
    }

    @Override
    public void updateTag(Tag tag) throws IntegrationException {
        HttpEntity<Tag> request = new HttpEntity<>(tag);
        restTemplate.put(SERVER_URL + "/tag/update", request, Tag.class);
    }

    @Override
    public void deleteTag(Tag tag) throws IntegrationException {
        String requestUri = UriComponentsBuilder.fromUriString(SERVER_URL + "/tag/delete/{id}").buildAndExpand(tag.getId()).toUriString();
        restTemplate.delete(requestUri);
    }
}
