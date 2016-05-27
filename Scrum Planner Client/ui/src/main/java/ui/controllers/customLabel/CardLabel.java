package ui.controllers.customLabel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import integration.ProjectGateway;
import integration.StoryCardGateway;
import integration.StoryPanelGateway;
import integration.TaskCardGateway;
import integration.TaskPanelGateway;
import integration.exception.IntegrationException;
import javafx.event.ActionEvent;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import model.planner.card.Card;
import model.planner.card.StoryCard;
import model.planner.card.TaskCard;
import model.planner.project.Project;
import model.planner.taskboard.Panel;
import model.planner.taskboard.PanelType;
import model.planner.taskboard.StoryPanel;
import model.planner.taskboard.TaskPanel;
import ui.ClientBoot;
import ui.dialogUtils.InformationDialogUtils;

/**
 * Custom label used to display card on the task board.
 *
 * @author Stefan Pamparau
 */
public class CardLabel extends Label {
    private ContextMenu cardContextMenu;

    private ProjectGateway projectGateway;
    private StoryCardGateway storyCardGateway;
    private TaskCardGateway taskCardGateway;
    private StoryPanelGateway storyPanelGateway;
    private TaskPanelGateway taskPanelGateway;

    private Project project;
    private Card card;
    private List<VBox> panels;

    public CardLabel(Project project, Card card, List<VBox> panels) {
        initializeContextMenu();
        this.project = project;
        this.card = card;
        this.panels = panels;
        initializeGateways();
    }

    /**
     * Initializes the context menu by adding it's menu items.
     */
    private void initializeContextMenu() {
        cardContextMenu = new ContextMenu();
        MenuItem updateCard = new MenuItem("Update card");
        MenuItem moveLeft = new MenuItem("Move left");
        MenuItem moveRight = new MenuItem("Move right");
        MenuItem deleteCard = new MenuItem("Delete card");
        cardContextMenu.getItems().addAll(updateCard, moveLeft, moveRight, deleteCard);
        addUpdateCardInfoHandler(updateCard);
        addMoveLeftHandler(moveLeft);
        addMoveRightHandler(moveRight);
        addDeleteCardHandler(deleteCard);
        this.setContextMenu(cardContextMenu);
    }

    private void initializeGateways() {
        projectGateway = (ProjectGateway) ClientBoot.getApplicationContext().getBean("projectGateway");
        storyCardGateway = (StoryCardGateway) ClientBoot.getApplicationContext().getBean("storyCardGateway");
        taskCardGateway = (TaskCardGateway) ClientBoot.getApplicationContext().getBean("taskCardGateway");
        storyPanelGateway = (StoryPanelGateway) ClientBoot.getApplicationContext().getBean("storyPanelGateway");
        taskPanelGateway = (TaskPanelGateway) ClientBoot.getApplicationContext().getBean("taskPanelGateway");
    }

    private void addUpdateCardInfoHandler(MenuItem updateCard) {
        updateCard.setOnAction((ActionEvent event) -> {


        });
    }

    private void addMoveLeftHandler(MenuItem moveLeft) {
        moveLeft.setOnAction((ActionEvent event) -> {
            try {
                List<Panel> sortedPanels = new ArrayList<>();
                sortedPanels.addAll(project.getTaskBoard().getPanels());
                Collections.sort(sortedPanels);
                int currentPosition = 0;

                for (Panel panel : sortedPanels) {
                    if (panel.getPanelType() == PanelType.STORY_PANEL) {
                        StoryPanel storyPanel = storyPanelGateway.getStoryPanel(panel.getId());
                        for (StoryCard storyCard : storyPanel.getStoryCards()) {
                            if (storyCard.getId().equals(card.getId())) {
                                InformationDialogUtils.displayInformationDialog("Cannot move story card", "Cannot move story card", "Cannot move story card");
                                break;
                            }
                        }
                    }

                    if (panel.getPanelType() == PanelType.TASK_PANEL) {
                        TaskPanel taskPanel = taskPanelGateway.getTaskPanel(panel.getId());
                        for (TaskCard taskCard : taskPanel.getTaskCards()) {
                            if (taskCard.getId().equals(card.getId())) {
                                if (currentPosition > 1) {
                                    TaskPanel previous = taskPanelGateway.getTaskPanel(sortedPanels.get(currentPosition - 1).getId());
                                    taskCard.setTaskPanel(previous);
                                    taskCardGateway.updateTaskCard(taskCard);
                                    panels.get(currentPosition).getChildren().remove(this);
                                    panels.get(currentPosition - 1).getChildren().add(this);
                                    break;
                                } else {
                                    InformationDialogUtils.displayInformationDialog("Cannot move task card", "Cannot move task card", "Cannot move task card");
                                }
                            }
                        }
                    }
                    currentPosition++;
                }
            } catch (IntegrationException e) {
                e.printStackTrace();
            }
        });
    }

    private void addMoveRightHandler(MenuItem moveRight) {
        moveRight.setOnAction((ActionEvent event) -> {
            try {
                List<Panel> sortedPanels = new ArrayList<>();
                sortedPanels.addAll(project.getTaskBoard().getPanels());
                Collections.sort(sortedPanels);
                int currentPosition = 0;

                boolean found = false;
                for (Panel panel : sortedPanels) {
                    if(found == false) {
                        if (panel.getPanelType() == PanelType.STORY_PANEL) {
                            StoryPanel storyPanel = storyPanelGateway.getStoryPanel(panel.getId());
                            for (StoryCard storyCard : storyPanel.getStoryCards()) {
                                if (storyCard.getId().equals(card.getId())) {
                                    InformationDialogUtils.displayInformationDialog("Cannot move story card", "Cannot move story card", "Cannot move story card");
                                    found = true;
                                    break;
                                }
                            }
                        }

                        if (panel.getPanelType() == PanelType.TASK_PANEL) {
                            TaskPanel taskPanel = taskPanelGateway.getTaskPanel(panel.getId());
                            for (TaskCard taskCard : taskPanel.getTaskCards()) {
                                if (taskCard.getId().equals(card.getId())) {
                                    if (currentPosition > 0 && currentPosition < sortedPanels.size() - 1) {
                                        TaskPanel next = taskPanelGateway.getTaskPanel(sortedPanels.get(currentPosition + 1).getId());
                                        taskCard.setTaskPanel(next);
                                        taskCardGateway.updateTaskCard(taskCard);
                                        panels.get(currentPosition).getChildren().remove(this);
                                        panels.get(currentPosition + 1).getChildren().add(this);
                                        found = true;
                                        break;
                                    } else {
                                        System.out.println(currentPosition);
                                        InformationDialogUtils.displayInformationDialog("Cannot move task card", "Cannot move task card", "Cannot move task card");
                                    }
                                }
                            }
                        }
                    }
                    currentPosition++;
                }
            } catch (IntegrationException e) {
                e.printStackTrace();
            }
        });
    }

    private void addDeleteCardHandler(MenuItem deleteCard) {
        deleteCard.setOnAction((ActionEvent event) -> {

        });
    }
}
