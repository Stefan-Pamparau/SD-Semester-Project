package ui.dialogUtils;

import javafx.application.Platform;
import javafx.scene.control.Alert;

/**
 * Class that facilitates the creation of information dialogs.
 *
 * @author Stefan Pamparau
 */
public class InformationDialogUtils {
    public static void displayInformationDialog(String title, String header, String content) {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setResizable(true);
            alert.setTitle(title);
            alert.setHeaderText(header);
            alert.setContentText(content);
            alert.showAndWait();
        });
    }
}
