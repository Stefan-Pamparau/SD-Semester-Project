package model.planner.user;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.OneToMany;

/**
 * Model class which represents a project manager.
 *
 * @author Stefan Pamparau
 */
@DiscriminatorValue("EMPLOYEE")
public class ProjectManager extends Employee {
    @OneToMany
    private Set<Developer> developers;
}
