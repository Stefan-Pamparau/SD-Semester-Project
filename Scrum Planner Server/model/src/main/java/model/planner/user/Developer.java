package model.planner.user;

import javax.persistence.DiscriminatorValue;
import javax.persistence.ManyToOne;

/**
 * Model class which represents a developer employee.
 *
 * @author Stefan Pamparau
 */
@DiscriminatorValue("EMPLOYEE")
public class Developer extends Employee {

    @ManyToOne
    private ProjectManager projectManager;

    public ProjectManager getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(ProjectManager projectManager) {
        this.projectManager = projectManager;
    }
}
