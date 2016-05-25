package model.planner.card;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import model.planner.taskboard.StoryPanel;

/**
 * Model class which represents a story card.
 *
 * @author Stefan Pamparau
 */
@Entity
@DiscriminatorValue("STORY_CARD")
public class StoryCard extends Card {
    private Integer storyPoints;

    @ManyToOne
    private StoryPanel storyPanel;

    public Integer getStoryPoints() {
        return storyPoints;
    }

    public void setStoryPoints(Integer storyPoints) {
        this.storyPoints = storyPoints;
    }

    public StoryPanel getStoryPanel() {
        return storyPanel;
    }

    public void setStoryPanel(StoryPanel storyPanel) {
        this.storyPanel = storyPanel;
    }
}
