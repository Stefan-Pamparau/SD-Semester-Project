package ui.dialogUtils;

import java.sql.Timestamp;
import java.util.Optional;

import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.planner.card.CardType;
import model.planner.card.TaskCard;

/**
 * Class which creates task card specific dialogs.
 *
 * @author Stefan Pamparau
 */
public class TaskCardDialogUtils {
    /**
     * Dialog that facilitates the insertion of a client.
     *
     * @return - returns the client object to be inserted
     */
    public static Optional<TaskCard> createInsertTaskCardInformationDialog() {
        Dialog<TaskCard> dialog = new Dialog<>();
        dialog.setTitle("Insert task card");
        dialog.setHeaderText("Please enter the task cards's information");

        dialog.setResizable(true);

        Label titleLabel = new Label("Title: ");
        Label descriptionLabel = new Label("Description: ");
        Label stateLabel = new Label("State: ");
        Label estimationLabel = new Label("Estimation: ");

        TextField titleTextField = new TextField();
        TextField descriptionTextField = new TextField();
        TextField stateTextField = new TextField();
        TextField estimationTextFeld = new TextField();

        GridPane grid = new GridPane();
        grid.add(titleLabel, 1, 1);
        grid.add(descriptionLabel, 1, 2);
        grid.add(stateLabel, 1, 3);
        grid.add(estimationLabel, 1, 4);

        grid.add(titleTextField, 2, 1);
        grid.add(descriptionTextField, 2, 2);
        grid.add(stateTextField, 2, 3);
        grid.add(estimationTextFeld, 2, 4);

        dialog.getDialogPane().setContent(grid);

        ButtonType insertUser = new ButtonType("Submit", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(insertUser, ButtonType.CANCEL);

        dialog.setResultConverter(dialogButton -> {
            if ((dialogButton == insertUser) && checkInputDataIntegrity(titleTextField.getText(), descriptionTextField.getText(), stateTextField.getText(), estimationTextFeld.getText())) {
                TaskCard taskCard = new TaskCard();
                taskCard.setTitle(titleTextField.getText());
                taskCard.setDescription(descriptionTextField.getText());
                taskCard.setFinishEstimation(Timestamp.valueOf(estimationTextFeld.getText()));
                taskCard.setTags(null);
                taskCard.setCardType(CardType.TASK_CARD);

                return taskCard;
            }
            return null;
        });

        return dialog.showAndWait();
    }

    private static boolean checkInputDataIntegrity(String title, String description, String state, String estimation) {
        if (!title.replaceAll("\\s", "").matches("\\w+")) {
            return false;
        }

        if (!description.replaceAll("\\s", "").matches("\\w+")) {
            return false;
        }

        if (!state.replaceAll("\\s", "").matches("\\w+")) {
            return false;
        }

        if (!estimation.matches("\\d\\d\\d\\d-\\d?\\d-\\d?\\d \\d\\d:\\d\\d:\\d\\d")) {
            return false;
        }

        return true;
    }
}
