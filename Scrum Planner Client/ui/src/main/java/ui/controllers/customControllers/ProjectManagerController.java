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
 * Controller which handles project manager actions.
 *
 * @author Stefan Pamparau
 */
public class ProjectManagerController extends Menu implements Initializable {
    private static final String LOCALES_EN_PATH = "locales/locale";
    private static final String PROJECT_MANAGER_CONTROLLER_VIEW_PATH = "/views/customControllerViews/projectManagerControllerView.fxml";

    public ProjectManagerController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(PROJECT_MANAGER_CONTROLLER_VIEW_PATH), ResourceBundle.getBundle(LOCALES_EN_PATH, new Locale("en", "EN")));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            InformationDialogUtils.displayInformationDialog("Cannot load Project Manager controller", "Cannot load Project Manager controller", "Cannot load Project Manager controller");
        }
    }

    public void handleGetProjectManagerAction(ActionEvent actionEvent) {

    }

    public void handleAddProjectManagerAction(ActionEvent actionEvent) {

    }

    public void handleUpdateProjectManagerAction(ActionEvent actionEvent) {

    }

    public void handleDeleteProjectManagerAction(ActionEvent actionEvent) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
