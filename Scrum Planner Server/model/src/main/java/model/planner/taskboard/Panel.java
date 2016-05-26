package model.planner.taskboard;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Model class which represents a panel present on the task board.
 *
 * @author Stefan Pamparau
 */
@Entity
@Table(name = "panel")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "panel_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("SIMPLE_PANEL")
public class Panel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "panel_type", insertable = false, updatable = false)
    private PanelType panelType;

    @JsonIgnore
    @ManyToOne
    private TaskBoard taskBoard;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PanelType getPanelType() {
        return panelType;
    }

    public void setPanelType(PanelType panelType) {
        this.panelType = panelType;
    }

    public TaskBoard getTaskBoard() {
        return taskBoard;
    }

    public void setTaskBoard(TaskBoard taskBoard) {
        this.taskBoard = taskBoard;
    }
}
