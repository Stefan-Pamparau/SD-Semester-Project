package model.planner.user;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 * Model class which represents a project manager.
 *
 * @author Stefan Pamparau
 */
@DiscriminatorValue("EMPLOYEE")
public class ProjectManager extends Employee {

    @OneToMany(mappedBy = "projectManager", fetch = FetchType.EAGER)
    private Set<Developer> developers;
}
