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
 * Controller which handles story panel specific actions.
 *
 * @author Stefan Pamparau
 */
public class StoryPanelController extends Menu implements Initializable {
    private static final String LOCALES_EN_PATH = "locales/locale";
    private static final String STORY_PANEL_CONTROLLER_VIEW_PATH = "/views/customControllerViews/storyPanelControllerView.fxml";

    public StoryPanelController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORY_PANEL_CONTROLLER_VIEW_PATH), ResourceBundle.getBundle(LOCALES_EN_PATH, new Locale("en", "EN")));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            InformationDialogUtils.displayInformationDialog("Cannot load Story Panel controller", "Cannot load Story Panel controller", "Cannot load Story Panel controller");
        }
    }

    public void handleGetStoryPanelAction(ActionEvent actionEvent) {

    }

    public void handleAddStoryPanelAction(ActionEvent actionEvent) {

    }

    public void handleUpdateStoryPanelAction(ActionEvent actionEvent) {

    }

    public void handleDeleteStoryPanelAction(ActionEvent actionEvent) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
