package integration.impl;

import integration.EmployeeGateway;
import integration.exception.IntegrationException;
import model.planner.user.Employee;

/**
 * Default implementation of the EmployeeGateway interface.
 *
 * @author Stefan Pamparau
 */
public class DefaultEmployeeGatewayImpl implements EmployeeGateway {
    @Override
    public Employee getEmployee(Integer id) throws IntegrationException {
        return null;
    }

    @Override
    public Employee findEmployeeByCNP(String CNP) throws IntegrationException {
        return null;
    }

    @Override
    public void insertEmployee(Employee employee) throws IntegrationException {

    }

    @Override
    public void updateEmployee(Employee employee) throws IntegrationException {

    }

    @Override
    public void deleteEmployee(Employee employee) throws IntegrationException {

    }
}
