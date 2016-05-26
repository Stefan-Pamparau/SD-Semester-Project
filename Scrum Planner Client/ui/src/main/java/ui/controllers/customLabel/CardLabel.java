package ui.controllers.customLabel;

import java.util.List;

import integration.ProjectGateway;
import integration.StoryCardGateway;
import integration.TaskCardGateway;
import javafx.event.ActionEvent;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import model.planner.card.Card;
import model.planner.project.Project;
import ui.ClientBoot;

/**
 * Custom label used to display card on the task board.
 *
 * @author Stefan Pamparau
 */
public class CardLabel extends Label {
    private ContextMenu clientContextMenu;

    private ProjectGateway projectGateway;
    private StoryCardGateway storyCardGateway;
    private TaskCardGateway taskCardGateway;

    public CardLabel(Project project, Card card, List<VBox> panels) {
        initializeContextMenu();
    }

    /**
     * Initializes the context menu by adding it's menu items.
     */
    private void initializeContextMenu() {
        clientContextMenu = new ContextMenu();
        MenuItem updateCard = new MenuItem("Update card");
        MenuItem moveLeft = new MenuItem("Move left");
        MenuItem moveRight = new MenuItem("Move right");
        MenuItem deleteCard = new MenuItem("Delete card");
        clientContextMenu.getItems().addAll(updateCard, moveLeft, moveRight, deleteCard);
        addUpdateCardInfoHandler(updateCard);
        addMoveLeftHandler(moveLeft);
        addMoveRightHandler(moveRight);
        addDeleteCardHandler(deleteCard);
    }

    private void initializeGateways() {
        projectGateway = (ProjectGateway) ClientBoot.getApplicationContext().getBean("projectGateway");
        storyCardGateway = (StoryCardGateway) ClientBoot.getApplicationContext().getBean("storyCardGateway");
        taskCardGateway = (TaskCardGateway) ClientBoot.getApplicationContext().getBean("taskCardGateway");
    }

    private void addUpdateCardInfoHandler(MenuItem viewClientInfo) {
        viewClientInfo.setOnAction((ActionEvent event) -> {

        });
    }

    private void addMoveLeftHandler(MenuItem updateClient) {
        updateClient.setOnAction((ActionEvent event) -> {

        });
    }

    private void addMoveRightHandler(MenuItem deleteClient) {
        deleteClient.setOnAction((ActionEvent event) -> {

        });
    }

    private void addDeleteCardHandler(MenuItem viewAccounts) {
        viewAccounts.setOnAction((ActionEvent event) -> {

        });
    }
}
