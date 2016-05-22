package model.planner.card;

import java.sql.Timestamp;
import java.util.Set;

/**
 * Model class which represents a task card present on a task board.
 *
 * @author Stefan Pamparau
 */
public class TaskCard {
    private Integer id;
    private String state;
    private Timestamp finishEstimation;
    private Set<Tag> tags;
}
