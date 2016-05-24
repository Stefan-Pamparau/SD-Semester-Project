package model.planner.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import model.planner.taskboard.TaskBoard;
import model.planner.user.User;

/**
 * Model class which represents a project on the board.
 *
 * @author Stefan Pamparau
 */
@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private TaskBoard taskBoard;
    private String name;

    @Column(name = "permission_type", insertable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private PermissionType permissionType;

    @ManyToOne
    private User user;
}
