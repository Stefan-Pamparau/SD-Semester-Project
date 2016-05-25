package integration.impl;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import integration.CompanyGateway;
import integration.exception.IntegrationException;
import model.planner.user.Company;

/**
 * Default implementation of the CompanyGateway interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultCompanyGatewayImpl implements CompanyGateway {
    private static final String SERVER_URL = "http://localhost:8080";

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public Company getCompany(Integer id) throws IntegrationException {
        String requestUri = UriComponentsBuilder.fromUriString(SERVER_URL + "/company/get/{id}").buildAndExpand(id).toUriString();
        return restTemplate.getForObject(requestUri, Company.class);
    }

    @Override
    public Company findCompanyByRegistrationNumber(String registrationNumber) throws IntegrationException {
        String requestUri = UriComponentsBuilder.fromUriString(SERVER_URL + "/company/get").queryParam("registrationNumber", registrationNumber).toUriString();
        return restTemplate.getForObject(requestUri, Company.class);
    }

    @Override
    public void insertCompany(Company company) throws IntegrationException {
        HttpEntity<Company> request = new HttpEntity<>(company);
        Company receivedCompany = restTemplate.postForObject(SERVER_URL + "/company/insert", request, Company.class);
    }

    @Override
    public void updateCompany(Company company) throws IntegrationException {
        HttpEntity<Company> request = new HttpEntity<>(company);
        restTemplate.put(SERVER_URL + "/company/update", request, Company.class);
    }

    @Override
    public void deleteCompany(Company company) throws IntegrationException {
        String requestUri = UriComponentsBuilder.fromUriString(SERVER_URL + "/company/delete/{id}").buildAndExpand(company.getId()).toUriString();
        restTemplate.delete(requestUri);
    }
}
