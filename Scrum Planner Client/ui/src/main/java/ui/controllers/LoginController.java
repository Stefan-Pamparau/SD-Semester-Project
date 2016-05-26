package ui.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import integration.LoginGateway;
import integration.exception.IntegrationException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.planner.user.User;
import ui.ClientBoot;
import ui.dialogUtils.InformationDialogUtils;

/**
 * Controller responding to login requests.
 *
 * @author Stefan Pamparau
 */
public class LoginController implements Initializable {
    @FXML
    private TextField emailTextField;
    @FXML
    private PasswordField passwordTextField;

    private LoginGateway loginGateway;

    public void handleLogin(ActionEvent actionEvent) {
        try {
            User user = loginGateway.getUserByEmailAndPassword(emailTextField.getText(), passwordTextField.getText());

            if (user != null) {
                ClientBoot.getInstance().goToProjectsView();
            } else {
                InformationDialogUtils.displayInformationDialog("Incorrect login credentials", "Incorrect login credentials", "Incorrect login credentials");
            }

        } catch (IntegrationException e) {
            InformationDialogUtils.displayInformationDialog("Cannot perform login", "Cannot perform login", e.getLocalizedMessage());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loginGateway = (LoginGateway) ClientBoot.getApplicationContext().getBean("loginGateway");
    }
}
