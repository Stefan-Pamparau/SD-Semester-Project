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
 * Controller which handles tag specific requests.
 *
 * @author Stefan Pamparau
 */
public class TagController extends Menu implements Initializable {
    private static final String LOCALES_EN_PATH = "locales/locale";
    private static final String TAG_CONTROLLER_VIEW_PATH = "/views/customControllerViews/tagControllerView.fxml";

    public TagController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(TAG_CONTROLLER_VIEW_PATH), ResourceBundle.getBundle(LOCALES_EN_PATH, new Locale("en", "EN")));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            InformationDialogUtils.displayInformationDialog("Cannot load Tag controller", "Cannot load Tag controller", "Cannot load Tag controller");
        }
    }

    public void handleGetTagAction(ActionEvent actionEvent) {

    }

    public void handleAddTagAction(ActionEvent actionEvent) {

    }

    public void handleUpdateTagAction(ActionEvent actionEvent) {

    }

    public void handleDeleteTagAction(ActionEvent actionEvent) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
