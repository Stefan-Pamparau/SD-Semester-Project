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
 * Controller which handles story card specific actions.
 *
 * @author Stefan Pamparau
 */
public class StoryCardController extends Menu implements Initializable {
    private static final String LOCALES_EN_PATH = "locales/locale";
    private static final String STORY_CARD_CONTROLLER_VIEW_PATH = "/views/customControllerViews/storyCardControllerView.fxml";

    public StoryCardController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORY_CARD_CONTROLLER_VIEW_PATH), ResourceBundle.getBundle(LOCALES_EN_PATH, new Locale("en", "EN")));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            InformationDialogUtils.displayInformationDialog("Cannot load Story Card controller", "Cannot load Story Card controller", "Cannot load Story Card controller");
        }
    }

    public void handleGetStoryCardAction(ActionEvent actionEvent) {

    }

    public void handleAddStoryCardAction(ActionEvent actionEvent) {

    }

    public void handleUpdateStoryCardAction(ActionEvent actionEvent) {

    }

    public void handleDeleteStoryCardAction(ActionEvent actionEvent) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
