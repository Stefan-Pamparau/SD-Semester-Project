package model.user;

import java.util.Set;

/**
 * Model class which represents an employee of a company.
 *
 * @author Stefan Pamparau
 */
public class Employee extends User {
    private Integer id;
    private EmployeeType employeeType;
    private Set<Employee> subordinates;
    private Company company;
}
