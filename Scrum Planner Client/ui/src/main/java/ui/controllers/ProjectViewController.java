package ui.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import integration.LoginGateway;
import integration.ProjectGateway;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import model.planner.project.Project;
import model.planner.user.User;
import ui.ClientBoot;

/**
 * Controller which handles the project view.
 *
 * @author Stefan Pamparau
 */
public class ProjectViewController implements Initializable {
    @FXML
    private GridPane root;
    @FXML
    private MenuBar optionsMenuBar;

    private LoginGateway loginGateway;
    private ProjectGateway projectGateway;


    /**
     * Initializes the options menu bar's width to the root's width.
     */
    private void initializeOptionsMenuBar() {
        optionsMenuBar.prefWidthProperty().bind(root.prefWidthProperty());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeOptionsMenuBar();
        loginGateway = (LoginGateway) ClientBoot.getApplicationContext().getBean("loginGateway");
        projectGateway = (ProjectGateway) ClientBoot.getApplicationContext().getBean("projectGateway");
        initializeProjects();
    }

    private void initializeProjects() {
        User user = loginGateway.getCurrentlyLoggedUser();
        Set<Project> projects = user.getProjects();

        int currentRow = 1;
        for (Project project : projects) {
            Label projectBox = new Label(getProjectInfo(project));
            projectBox.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    ClientBoot.getInstance().goToTaskBoardView(project);
                    System.out.println("mouse click detected! " + event.getSource());
                }
            });
            root.add(projectBox, 0, currentRow);
            projectBox.getStyleClass().add("project-label");
            currentRow++;
        }
    }

    private String getProjectInfo(Project project) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(project.getName());

        return buffer.toString();
    }
}
