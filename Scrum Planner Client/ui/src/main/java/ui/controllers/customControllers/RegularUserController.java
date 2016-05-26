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
 * Controller which handles regular user actions.
 *
 * @author Stefan Pamparau
 */
public class RegularUserController extends Menu implements Initializable {
    private static final String LOCALES_EN_PATH = "locales/locale";
    private static final String REGULAR_USER_CONTROLLER_VIEW_PATH = "/views/customControllerViews/regularUserControllerView.fxml";

    public RegularUserController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(REGULAR_USER_CONTROLLER_VIEW_PATH), ResourceBundle.getBundle(LOCALES_EN_PATH, new Locale("en", "EN")));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            InformationDialogUtils.displayInformationDialog("Cannot load Regular User controller", "Cannot load Regular User controller", "Cannot load Regular User controller");
        }
    }

    public void handleGetRegularUserAction(ActionEvent actionEvent) {

    }

    public void handleAddRegularUserAction(ActionEvent actionEvent) {

    }

    public void handleUpdateRegularUserAction(ActionEvent actionEvent) {

    }

    public void handleDeleteRegularUserAction(ActionEvent actionEvent) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
