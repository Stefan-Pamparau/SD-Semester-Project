package model.user;

import javax.persistence.DiscriminatorValue;

/**
 * Model class which represents a developer employee.
 *
 * @author Stefan Pamparau
 */
@DiscriminatorValue("EMPLOYEE")
public class Developer extends Employee {
}
