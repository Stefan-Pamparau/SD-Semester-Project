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
 * Controller which handles project specific actions.
 *
 * @author Stefan Pamparau
 */
public class ProjectController extends Menu implements Initializable {
    private static final String LOCALES_EN_PATH = "locales/locale";
    private static final String PROJECT_CONTROLLER_VIEW_PATH = "/views/customControllerViews/projectControllerView.fxml";

    public ProjectController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(PROJECT_CONTROLLER_VIEW_PATH), ResourceBundle.getBundle(LOCALES_EN_PATH, new Locale("en", "EN")));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            InformationDialogUtils.displayInformationDialog("Cannot load Project controller", "Cannot load Project controller", "Cannot load Project controller");
        }
    }

    public void handleGetProjectAction(ActionEvent actionEvent) {

    }

    public void handleAddProjectAction(ActionEvent actionEvent) {

    }

    public void handleUpdateProjectAction(ActionEvent actionEvent) {

    }

    public void handleDeleteProjectAction(ActionEvent actionEvent) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
