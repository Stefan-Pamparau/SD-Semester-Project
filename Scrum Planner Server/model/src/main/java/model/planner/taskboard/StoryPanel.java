package model.planner.taskboard;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import model.planner.card.StoryCard;

/**
 * Model class which represents the story panel present on the taskboard.
 *
 * @author Stefan Pamparau
 */
@Entity
@Table(name = "story_panel")
@DiscriminatorValue("STORY_PANEL")
public class StoryPanel extends Panel {

    @OneToMany(mappedBy = "storyPanel", fetch = FetchType.EAGER)
    private Set<StoryCard> storyCards;
}
