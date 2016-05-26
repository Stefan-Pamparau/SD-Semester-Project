package ui.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.ResourceBundle;
import java.util.TreeSet;

import integration.StoryPanelGateway;
import integration.TaskPanelGateway;
import integration.exception.IntegrationException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.planner.card.StoryCard;
import model.planner.card.TaskCard;
import model.planner.project.Project;
import model.planner.taskboard.Panel;
import model.planner.taskboard.PanelType;
import model.planner.taskboard.StoryPanel;
import model.planner.taskboard.TaskPanel;
import ui.ClientBoot;
import ui.controllers.customLabel.CardLabel;

/**
 * Controller which handles the taskboard view of a project.
 *
 * @author Stefan Pamparau
 */
public class TaskBoardView implements Initializable {
    @FXML
    public MenuBar optionsMenuBar;
    @FXML
    private GridPane root;

    private Project project;

    private StoryPanelGateway storyPanelGateway;
    private TaskPanelGateway taskPanelGateway;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeOptionsMenuBar();
        storyPanelGateway = (StoryPanelGateway) ClientBoot.getApplicationContext().getBean("storyPanelGateway");
        taskPanelGateway = (TaskPanelGateway) ClientBoot.getApplicationContext().getBean("taskPanelGateway");
    }

    /**
     * Initializes the options menu bar's width to the root's width.
     */
    private void initializeOptionsMenuBar() {
        optionsMenuBar.prefWidthProperty().bind(root.prefWidthProperty());
    }

    public void drawTaskBoard() {
        try {
            List<VBox> vBoxList = new ArrayList<>();

            int columnIndex = 0;
            List<Panel> panels = new ArrayList<>();
            panels.addAll(project.getTaskBoard().getPanels());
            Collections.sort(panels);

            for (Panel panel : panels) {
                VBox vBox = new VBox();
                vBoxList.add(vBox);

                if (panel.getPanelType() == PanelType.STORY_PANEL) {
                    StoryPanel storyPanel = storyPanelGateway.getStoryPanel(panel.getId());
                    for (StoryCard storyCard : storyPanel.getStoryCards()) {
                        StringBuffer buffer = new StringBuffer();
                        buffer.append(storyCard.getTitle());
                        buffer.append("\n");
                        buffer.append(storyCard.getDescription());
                        buffer.append("\n");
                        buffer.append(storyCard.getStoryPoints());

                        CardLabel cardLabel = new CardLabel(project, storyCard, vBoxList);
                        cardLabel.setText(buffer.toString());
                        cardLabel.getStyleClass().add("card-label");
                        vBox.getChildren().add(cardLabel);
                    }
                }

                if (panel.getPanelType() == PanelType.TASK_PANEL) {
                    TaskPanel taskPanel = taskPanelGateway.getTaskPanel(panel.getId());

                    for (TaskCard taskCard : taskPanel.getTaskCards()) {
                        StringBuffer buffer = new StringBuffer();
                        buffer.append(taskCard.getTitle());
                        buffer.append("\n");
                        buffer.append(taskCard.getDescription());
                        buffer.append("\n");
                        buffer.append(taskCard.getFinishEstimation());

                        CardLabel cardLabel = new CardLabel(project, taskCard, vBoxList);
                        cardLabel.setText(buffer.toString());
                        cardLabel.getStyleClass().add("card-label");
                        vBox.getChildren().add(cardLabel);
                    }
                }
                root.add(vBox, columnIndex, 1);
                columnIndex++;

                Separator separator = new Separator();
                separator.setOrientation(Orientation.VERTICAL);
                separator.prefHeightProperty().bind(root.prefHeightProperty());
                root.add(separator, columnIndex, 1);
                columnIndex++;
            }
        } catch (IntegrationException e) {
            e.printStackTrace();
        }
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
