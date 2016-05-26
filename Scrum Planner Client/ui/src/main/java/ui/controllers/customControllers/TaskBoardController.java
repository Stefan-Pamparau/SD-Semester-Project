package ui.controllers.customControllers;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import ui.dialogUtils.InformationDialogUtils;

/**
 * Controller which handles task board specific actions.
 *
 * @author Stefan Pamparau
 */
public class TaskBoardController extends Menu implements Initializable {
    private static final String LOCALES_EN_PATH = "locales/locale";
    private static final String TASKBOARD_CONTROLLER_VIEW_PATH = "/views/customControllerViews/taskBoardControllerView.fxml";

    public TaskBoardController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(TASKBOARD_CONTROLLER_VIEW_PATH), ResourceBundle.getBundle(LOCALES_EN_PATH, new Locale("en", "EN")));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            InformationDialogUtils.displayInformationDialog("Cannot load TaskBoard controller", "Cannot load TaskBoard controller", "Cannot load TaskBoard controller");
        }
    }

    public void handleGetTaskBoardAction(ActionEvent actionEvent) {

    }

    public void handleAddTaskBoardAction(ActionEvent actionEvent) {

    }

    public void handleUpdateTaskBoardAction(ActionEvent actionEvent) {

    }

    public void handleDeleteTaskBoardAction(ActionEvent actionEvent) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
