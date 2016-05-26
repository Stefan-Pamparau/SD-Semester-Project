package ui.controllers.customControllers;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import ui.ClientBoot;
import ui.dialogUtils.InformationDialogUtils;

/**
 * Controller which handles transitions between views.
 *
 * @author Stefan Pamparau
 */
public class TransitionController extends Menu implements Initializable {
    private static final String LOCALES_EN_PATH = "locales/locale";
    private static final String TRANSITION_CONTROLLER_VIEW_PATH = "/views/customControllerViews/transitionControllerView.fxml";

    public TransitionController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(TRANSITION_CONTROLLER_VIEW_PATH), ResourceBundle.getBundle(LOCALES_EN_PATH, new Locale("en", "EN")));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            InformationDialogUtils.displayInformationDialog("Cannot load Transition controller", "Cannot load Transition controller", "Cannot load Transition controller");
        }
    }

    public void handleGoToLogin(ActionEvent actionEvent) {
        ClientBoot.getInstance().goToLoginView();
    }

    public void handleGoToProjects(ActionEvent actionEvent) {
        ClientBoot.getInstance().goToProjectsView();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
