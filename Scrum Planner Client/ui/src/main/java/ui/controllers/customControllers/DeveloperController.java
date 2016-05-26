package ui.controllers.customControllers;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import integration.DeveloperGateway;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import ui.ClientBoot;
import ui.dialogUtils.InformationDialogUtils;

/**
 * Controller which handles developer specific requests.
 *
 * @author Stefan Pamparau
 */
public class DeveloperController extends Menu implements Initializable {
    private static final String LOCALES_EN_PATH = "locales/locale";
    private static final String DEVELOPER_CONTROLLER_VIEW_PATH = "/views/customControllerViews/developerControllerView.fxml";

    private DeveloperGateway developerGateway;

    public DeveloperController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(DEVELOPER_CONTROLLER_VIEW_PATH), ResourceBundle.getBundle(LOCALES_EN_PATH, new Locale("en", "EN")));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            InformationDialogUtils.displayInformationDialog("Cannot load Developer controller", "Cannot load Developer controller", "Cannot load Developer controller");
        }
    }

    public void handleGetDeveloperAction(ActionEvent actionEvent) {

    }

    public void handleAddDeveloperAction(ActionEvent actionEvent) {

    }

    public void handleUpdateDeveloperAction(ActionEvent actionEvent) {

    }

    public void handleDeleteDeveloperAction(ActionEvent actionEvent) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        developerGateway = (DeveloperGateway) ClientBoot.getApplicationContext().getBean("developerGateway");
    }
}
