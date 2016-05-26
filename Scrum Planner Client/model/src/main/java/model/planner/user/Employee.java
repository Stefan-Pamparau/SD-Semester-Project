package model.planner.user;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

/**
 * Model class which represents an employee of a company.
 *
 * @author Stefan Pamparau
 */
@Entity
@DiscriminatorValue("EMPLOYEE")
public class Employee extends User {
    @ManyToOne
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
