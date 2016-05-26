package model.planner.user;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

/**
 * Model class which represents a developer employee.
 *
 * @author Stefan Pamparau
 */
@Entity
@DiscriminatorValue("DEVELOPER")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@developerId")
public class Developer extends Employee {

    @ManyToOne
    @JoinTable(name = "projectManager_developer", joinColumns = {
            @JoinColumn(name = "developer_id") }, inverseJoinColumns = {
            @JoinColumn(name = "projectManager_id") })
    private ProjectManager projectManager;

    public ProjectManager getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(ProjectManager projectManager) {
        this.projectManager = projectManager;
    }
}
