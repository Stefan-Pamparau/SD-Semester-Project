package model.planner.taskboard;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import model.planner.card.StoryCard;

/**
 * Model class which represents the story panel present on the taskboard.
 *
 * @author Stefan Pamparau
 */
@Entity
@DiscriminatorValue("STORY_PANEL")
public class StoryPanel extends Panel {

    @OneToMany(mappedBy = "storyPanel", fetch = FetchType.EAGER)
    private Set<StoryCard> storyCards;

    public Set<StoryCard> getStoryCards() {
        return storyCards;
    }

    public void setStoryCards(Set<StoryCard> storyCards) {
        this.storyCards = storyCards;
    }
}
