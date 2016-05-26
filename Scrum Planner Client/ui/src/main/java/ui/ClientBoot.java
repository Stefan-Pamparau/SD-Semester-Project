package ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import integration.contextConfig.IntegrationContextConfig;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Class which boots up the client application.
 *
 * @author Stefan Pamparau
 */
public class ClientBoot extends Application {
    private static final String LOCALES_EN_PATH = "locales/locale";
    private static final String LOGIN_VIEW_PATH = "/views/login.fxml";
    private static final String PROJECTS_VIEW_PATH = "/views/projectsView.fxml";
    private static final String TASKBOARD_VIEW_PATH = "/views/taskBoardView.fxml";

    private static ClientBoot instance;
    private static ApplicationContext applicationContext;
    private Stage stage;

    public ClientBoot() {
        instance = this;
        applicationContext = new AnnotationConfigApplicationContext(IntegrationContextConfig.class);
    }

    public static ClientBoot getInstance() {
        return instance;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        ClientBoot.applicationContext = applicationContext;
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        stage.setTitle("Scrum planner");
        goToLoginView();
        stage.show();
    }

    public void goToLoginView() {
        replaceSceneRoot(LOGIN_VIEW_PATH);
    }

    public void goToProjectsView() {
        replaceSceneRoot(PROJECTS_VIEW_PATH);
    }

    public void goToTaskBoardView() {
        replaceSceneRoot(TASKBOARD_VIEW_PATH);
    }

    private void replaceSceneRoot(String fxmlPath) {
        Pane root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(fxmlPath), ResourceBundle.getBundle(LOCALES_EN_PATH, new Locale("en", "EN")), new JavaFXBuilderFactory());
            Scene scene = stage.getScene();
            if (scene == null) {
                scene = new Scene(root, 800, 600);
                stage.setScene(scene);
            } else {
                stage.getScene().setRoot(root);
            }
            stage.sizeToScene();
            bindRootToScene(scene, root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void bindRootToScene(Scene scene, Pane root) {
        root.prefHeightProperty().bind(scene.heightProperty());
        root.prefWidthProperty().bind(scene.widthProperty());
    }
}