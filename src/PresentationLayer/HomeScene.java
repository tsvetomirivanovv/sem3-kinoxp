package PresentationLayer;

import ApplicationLayer.HomeSceneController;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.time.LocalDate;

/**
 * Created by Andrei on 28/09/2016.
 */
public class HomeScene {

    private Scene homeScene;
    private BorderPane root;
    private Button manageMovieButton;
    private Button searchButton;
    private LocalDate date;

    public Scene setHomeScene() {

        // Elements
        DatePicker datePicker = new DatePicker();
        datePicker.setPromptText("mm/dd/yyyy");
        datePicker.setOnAction(e -> {
            date = datePicker.getValue();
        });

        HBox buttonBox = new HBox(20);
        VBox homeBox = new VBox(20);


        manageMovieButton = new Button("Manage movies");
        searchButton = new Button("Search");

        buttonBox.getChildren().add(manageMovieButton);
        buttonBox.getChildren().add(searchButton);
        buttonBox.setAlignment(Pos.CENTER);

        homeBox.getChildren().add(datePicker);
        homeBox.getChildren().add(buttonBox);
        homeBox.setAlignment(Pos.CENTER);

        root = new BorderPane();
        root.setCenter(homeBox);

        homeScene = new Scene(root, 500, 500);

        // make an instantiation of the Controller
        HomeSceneController homeSceneController = new HomeSceneController();

        manageMovieButton.setOnAction(e -> homeSceneController.changeScene("manage", null));
        searchButton.setOnAction(e -> {
            homeSceneController.changeScene("results", date);
        });

        homeScene.getStylesheets().add("CSS");
        return homeScene;
    }
}
