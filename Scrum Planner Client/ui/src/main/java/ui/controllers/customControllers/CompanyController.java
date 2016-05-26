package ui.controllers.customControllers;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import integration.CompanyGateway;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import ui.ClientBoot;
import ui.dialogUtils.InformationDialogUtils;

/**
 * Controller which handles company related actions.
 *
 * @author Stefan Pamparau
 */
public class CompanyController extends Menu implements Initializable {
    private static final String LOCALES_EN_PATH = "locales/locale";
    private static final String COMPANY_CONTROLLER_VIEW_PATH = "/views/customControllerViews/companyControllerView.fxml";

    private CompanyGateway companyGateway;

    public CompanyController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(COMPANY_CONTROLLER_VIEW_PATH), ResourceBundle.getBundle(LOCALES_EN_PATH, new Locale("en", "EN")));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            InformationDialogUtils.displayInformationDialog("Cannot load Company controller", "Cannot load Company controller", "Cannot load Company controller");
        }
    }

    public void handleGetCompanyAction(ActionEvent actionEvent) {

    }

    public void handleAddCompanyAction(ActionEvent actionEvent) {

    }

    public void handleUpdateCompanyAction(ActionEvent actionEvent) {

    }

    public void handleDeleteCompanyAction(ActionEvent actionEvent) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        companyGateway = (CompanyGateway) ClientBoot.getApplicationContext().getBean("companyGateway");
    }
}
