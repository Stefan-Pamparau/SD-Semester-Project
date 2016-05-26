package model.planner.taskboard;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
@DiscriminatorValue("TASK_PANEL")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@taskPanelId")
public class TaskPanel extends Panel {

    @OneToMany(mappedBy = "taskPanel", fetch = FetchType.EAGER)
    private Set<TaskCard> taskCards;

    public Set<TaskCard> getTaskCards() {
        return taskCards;
    }

    public void setTaskCards(Set<TaskCard> taskCards) {
        this.taskCards = taskCards;
    }
}
