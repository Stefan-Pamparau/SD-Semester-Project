package model.planner.taskboard;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@taskBoardId")
public class TaskBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "taskBoard", fetch = FetchType.EAGER)
    private Set<Panel> panels;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Panel> getPanels() {
        return panels;
    }

    public void setPanels(Set<Panel> panels) {
        this.panels = panels;
    }
}
