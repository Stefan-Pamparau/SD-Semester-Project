package model.user;

import java.util.Set;

import model.planner.project.Project;

/**
 * Model class which represents an user of the application.
 *
 * @author Stefan Pamparau
 */
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private String CNP;
    private UserType userType;
    private Set<Project> projects;
}
