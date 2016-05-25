package model.planner.user;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

/**
 * Model class which represents a project manager.
 *
 * @author Stefan Pamparau
 */
@Entity
@DiscriminatorValue("PROJECT_MANAGER")
public class ProjectManager extends Employee {

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "projectManager_developer", joinColumns = {
            @JoinColumn(name = "projectManager_id") }, inverseJoinColumns = {
            @JoinColumn(name = "developer_id") })
    private Set<Developer> developers = new HashSet<>();

    public Set<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<Developer> developers) {
        this.developers = developers;
    }
}
