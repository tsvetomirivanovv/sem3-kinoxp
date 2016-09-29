package PresentationLayer;

import ApplicationLayer.HomeSceneController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

/**
 * Created by Andrei on 28/09/2016.
 */
public class HomeScene {

    private Scene homeScene;
    private BorderPane root;
    private Button manageMovieButton;

    public Scene setHomeScene() {

        manageMovieButton = new Button("Manage movies");

        root = new BorderPane();
        root.setCenter(manageMovieButton);

        homeScene = new Scene(root, 500, 500);

        // make an instantiation of the Controller
        HomeSceneController homeSceneController = new HomeSceneController();

        manageMovieButton.setOnAction(e -> homeSceneController.changeToManageMovieScene());

        return homeScene;
    }
}
