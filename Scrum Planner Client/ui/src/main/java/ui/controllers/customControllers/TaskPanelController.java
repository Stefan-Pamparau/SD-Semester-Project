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
 * Controller which handles task panel related actions.
 *
 * @author Stefan Pamparau
 */
public class TaskPanelController extends Menu implements Initializable {
    private static final String LOCALES_EN_PATH = "locales/locale";
    private static final String PROJECT_CONTROLLER_VIEW_PATH = "/views/customControllerViews/taskPanelControllerView.fxml";

    public TaskPanelController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(PROJECT_CONTROLLER_VIEW_PATH), ResourceBundle.getBundle(LOCALES_EN_PATH, new Locale("en", "EN")));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            InformationDialogUtils.displayInformationDialog("Cannot load TaskPanel controller", "Cannot load TaskPanel controller", "Cannot load TaskPanel controller");
        }
    }

    public void handleGetTaskPanelAction(ActionEvent actionEvent) {

    }

    public void handleAddTaskPanelAction(ActionEvent actionEvent) {

    }

    public void handleUpdateTaskPanelAction(ActionEvent actionEvent) {

    }

    public void handleDeleteTaskPanelAction(ActionEvent actionEvent) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
