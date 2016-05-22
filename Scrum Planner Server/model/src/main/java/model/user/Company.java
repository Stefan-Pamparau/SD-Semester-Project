package model.user;

import java.sql.Timestamp;
import java.util.Set;

/**
 * Model class which represents a company.
 *
 * @author Stefan Pamparau
 */
public class Company {
    private Integer id;
    private String name;
    private Timestamp creationDate;
    private Set<Employee> employees;
}
