package integration.impl;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import integration.EmployeeGateway;
import integration.exception.IntegrationException;
import model.planner.user.Employee;

/**
 * Default implementation of the EmployeeGateway interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultEmployeeGatewayImpl implements EmployeeGateway {
    private static final String SERVER_URL = "http://localhost:8080";

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public Employee getEmployee(Integer id) throws IntegrationException {
        String requestUri = UriComponentsBuilder.fromUriString(SERVER_URL + "/employee/get/{id}").buildAndExpand(id).toUriString();
        return restTemplate.getForObject(requestUri, Employee.class);
    }

    @Override
    public Employee findEmployeeByCNP(String CNP) throws IntegrationException {
        String requestUri = UriComponentsBuilder.fromUriString(SERVER_URL + "/employee/get").queryParam("CNP", CNP).toUriString();
        return restTemplate.getForObject(requestUri, Employee.class);
    }

    @Override
    public Employee insertEmployee(Employee employee) throws IntegrationException {
        HttpEntity<Employee> request = new HttpEntity<>(employee);
        return restTemplate.postForObject(SERVER_URL + "/employee/insert", request, Employee.class);
    }

    @Override
    public void updateEmployee(Employee employee) throws IntegrationException {
        HttpEntity<Employee> request = new HttpEntity<>(employee);
        restTemplate.put(SERVER_URL + "/employee/update", request, Employee.class);
    }

    @Override
    public void deleteEmployee(Employee employee) throws IntegrationException {
        String requestUri = UriComponentsBuilder.fromUriString(SERVER_URL + "/employee/delete/{id}").buildAndExpand(employee.getId()).toUriString();
        restTemplate.delete(requestUri);
    }
}
