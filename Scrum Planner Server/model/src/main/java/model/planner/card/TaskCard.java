package model.planner.card;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class TaskCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String state;
    private Timestamp finishEstimation;

    @ManyToOne
    private TaskPanel taskPanel;

    @OneToMany(mappedBy = "taskCard", fetch = FetchType.EAGER)
    private Set<Tag> tags;
}
