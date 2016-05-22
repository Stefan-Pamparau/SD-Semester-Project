package model.planner.project;

import model.planner.taskboard.TaskBoard;
import model.user.User;

/**
 * Model class which represents a project on the board.
 *
 * @author Stefan Pamparau
 */
public class Project {
    private Integer id;
    private TaskBoard taskBoard;
    private String name;
    private PermissionType permissionType;
    private User user;
}
