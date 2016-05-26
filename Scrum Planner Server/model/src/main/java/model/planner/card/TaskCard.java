package model.planner.card;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import model.planner.taskboard.TaskPanel;

/**
 * Model class which represents a task card present on a task board.
 *
 * @author Stefan Pamparau
 */
@Entity
@DiscriminatorValue("TASK_CARD")
public class TaskCard extends Card {
    private String state;
    private Timestamp finishEstimation;

    @ManyToOne
    private TaskPanel taskPanel;

    @OneToMany(mappedBy = "taskCard", fetch = FetchType.EAGER)
    private Set<Tag> tags;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Timestamp getFinishEstimation() {
        return finishEstimation;
    }

    public void setFinishEstimation(Timestamp finishEstimation) {
        this.finishEstimation = finishEstimation;
    }

    public TaskPanel getTaskPanel() {
        return taskPanel;
    }

    public void setTaskPanel(TaskPanel taskPanel) {
        this.taskPanel = taskPanel;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }
}
