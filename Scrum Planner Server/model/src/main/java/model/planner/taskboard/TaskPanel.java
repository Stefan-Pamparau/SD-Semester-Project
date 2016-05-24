package model.planner.taskboard;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import model.planner.card.TaskCard;

/**
 * Model class which represents a task panel on the task board.
 *
 * @author Stefan Pamparau
 */
@Entity
@Table(name = "task_panel")
@DiscriminatorValue("TASK_PANEL")
public class TaskPanel extends Panel {

    @OneToMany(mappedBy = "taskPanel", fetch = FetchType.EAGER)
    private Set<TaskCard> taskCards;
}
