package model.planner.taskboard;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Model class which represents a task board afferent to a project.
 *
 * @author Stefan Pamparau
 */
@Entity
@Table(name = "task_board")
public class TaskBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "taskBoard", fetch = FetchType.EAGER)
    private Set<Panel> panels;
}
