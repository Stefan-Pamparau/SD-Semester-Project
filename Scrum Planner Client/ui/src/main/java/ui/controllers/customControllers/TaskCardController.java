package ui.controllers.customControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import integration.LoginGateway;
import integration.TaskCardGateway;
import integration.TaskPanelGateway;
import integration.exception.IntegrationException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import model.planner.card.TaskCard;
import model.planner.project.Project;
import model.planner.taskboard.Panel;
import model.planner.taskboard.TaskPanel;
import model.planner.user.User;
import ui.ClientBoot;
import ui.controllers.TaskBoardView;
import ui.dialogUtils.InformationDialogUtils;
import ui.dialogUtils.TaskCardDialogUtils;

/**
 * Controller which handles task card related actions.
 *
 * @author Stefan Pamparau
 */
public class TaskCardController extends Menu implements Initializable {
    private static final String LOCALES_EN_PATH = "locales/locale";
    private static final String TASKCARD_CONTROLLER_VIEW_PATH = "/views/customControllerViews/taskCardControllerView.fxml";

    private LoginGateway loginGateway;
    private TaskCardGateway taskCardGateway;
    private TaskPanelGateway taskPanelGateway;

    public TaskCardController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(TASKCARD_CONTROLLER_VIEW_PATH), ResourceBundle.getBundle(LOCALES_EN_PATH, new Locale("en", "EN")));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            InformationDialogUtils.displayInformationDialog("Cannot load TaskCard controller", "Cannot load TaskCard controller", "Cannot load TaskCard controller");
        }
    }

    public void handleGetTaskCardAction(ActionEvent actionEvent) {

    }

    public void handleAddTaskCardAction(ActionEvent actionEvent) {
        try {
            Project project = TaskBoardView.getInstance().getProject();

            if (project != null) {
                Optional<TaskCard> result = TaskCardDialogUtils.createInsertTaskCardInformationDialog();

                if (result.isPresent()) {
                    User user = loginGateway.getCurrentlyLoggedUser();

                    List<Panel> panels = new ArrayList<>();
                    panels.addAll(project.getTaskBoard().getPanels());
                    Collections.sort(panels);

                    TaskPanel taskPanel = taskPanelGateway.getTaskPanel(panels.get(1).getId());
                    TaskCard taskCard = result.get();
                    taskCard.setTaskPanel(taskPanel);
                    taskCardGateway.insertTaskCard(taskCard);

                    panels.remove(1);
                    panels.add(taskPanel);

                    TaskBoardView.getInstance().drawTaskBoard();
                }
            }
        } catch (IntegrationException e) {
            e.printStackTrace();
        }
    }

    public void handleUpdateTaskCardAction(ActionEvent actionEvent) {

    }

    public void handleDeleteTaskCardAction(ActionEvent actionEvent) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loginGateway = (LoginGateway) ClientBoot.getApplicationContext().getBean("loginGateway");
        taskCardGateway = (TaskCardGateway) ClientBoot.getApplicationContext().getBean("taskCardGateway");
        taskPanelGateway = (TaskPanelGateway) ClientBoot.getApplicationContext().getBean("taskPanelGateway");
    }
}
