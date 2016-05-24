package model.planner.card;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer storyPoints;

    @ManyToOne
    private StoryPanel storyPanel;
}
