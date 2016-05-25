package integration.impl;

import integration.TagGateway;
import integration.exception.IntegrationException;
import model.planner.card.Tag;

/**
 * Default implementation of the TagGateway interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultTagGatewayImpl implements TagGateway {
    @Override
    public Tag getTag(Integer id) throws IntegrationException {
        return null;
    }

    @Override
    public void insertTag(Tag tag) throws IntegrationException {

    }

    @Override
    public void updateTag(Tag tag) throws IntegrationException {

    }

    @Override
    public void deleteTag(Tag tag) throws IntegrationException {

    }
}
