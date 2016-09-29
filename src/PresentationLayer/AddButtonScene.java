package PresentationLayer;

import ApplicationLayer.AddSceneController;
import Kino.KinoXP;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;


public class AddButtonScene {

    private Stage window;
    private BorderPane borderPane;
    private FileChooser coverChooser;
    private File selectedFile;
    private Scene scene;
    private VBox vBoxLabel, vBoxTextField;
    private HBox hBox, hBoxButton;
    private Label name,duration,price,actors,description,cover,agelimit, coverPath, genre, rating;
    private TextField textFieldName, textFieldDuration, textFieldPrice, textFieldActors, textFieldDescription, textFieldAgeLimit, textFieldGenre, textFieldRating;
    private Button chooseFileButton, confirmButton;


    public void setAddScene (){
        window = new Stage();

        // Initializing the Labels, Buttons and stuff
        borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10,10,10,10));
        vBoxLabel = new VBox(20);
        vBoxLabel.setPadding(new Insets(40,40,40,40)); // LABEL VBOX
        vBoxTextField = new VBox(9);
        vBoxTextField.setPadding(new Insets(40,40,40,40)); // TEXTFIELD VBOX

        hBoxButton = new HBox(9); // BUTTON HBOX
        hBox = new HBox(); // MAIN HBOX

        name = new Label("Name: ");
        textFieldName = new TextField();
        textFieldName.setPromptText("Write name here ... ");

        duration = new Label("Duration: ");
        textFieldDuration = new TextField();
        textFieldDuration.setPromptText("Write duration here ...");
        textFieldDuration.setPrefWidth(250);

        price = new Label("Price: ");
        textFieldPrice = new TextField();
        textFieldPrice.setPromptText("Write price here ...");

        actors = new Label("Actors: ");
        textFieldActors = new TextField();
        textFieldActors.setPromptText("Wrie actors here ...");

        description = new Label("Description: ");
        textFieldDescription = new TextField();
        textFieldDescription.setPromptText("Write description here ...");

        agelimit = new Label("Age Limit: ");
        textFieldAgeLimit = new TextField();
        textFieldAgeLimit.setPromptText("Write age limit here ... ");


        genre = new Label("Genre: ");
        textFieldGenre = new TextField();
        textFieldGenre.setPromptText("Write genre here ... ");

        rating = new Label("Rating: ");
        textFieldRating = new TextField();
        textFieldRating.setPromptText("Write rating here ... ");

        cover = new Label("Cover: ");
        coverPath = new Label();
        chooseFileButton = new Button("Choose cover image");
        coverChooser = new FileChooser();

        confirmButton = new Button("OK");

        vBoxLabel.getChildren().addAll(name,duration,price,actors,description,agelimit,genre, rating,cover); // LABELS VBOX
        vBoxTextField.getChildren().addAll(textFieldName,textFieldDuration,textFieldPrice,textFieldActors,textFieldDescription,textFieldAgeLimit, textFieldGenre , textFieldRating,coverPath); // TEXFIELDS VBOX

        hBox.getChildren().addAll(vBoxLabel,vBoxTextField);
        hBoxButton.getChildren().addAll(chooseFileButton,confirmButton);
        hBoxButton.setAlignment(Pos.BOTTOM_RIGHT);

        borderPane.setCenter(hBox);
        borderPane.setBottom(hBoxButton);

        // make an instantiation of the Controller
        AddSceneController addSceneController = new AddSceneController();

        // Making functionality for the buttons
        chooseFileButton.setOnAction(e -> {
            selectedFile = coverChooser.showOpenDialog(KinoXP.window);
            String path = selectedFile.toString();
            coverPath.setText(path.substring(path.lastIndexOf("\\")));

        });
        confirmButton.setOnAction(e -> addSceneController.saveData(textFieldName.getText(), Integer.parseInt(textFieldDuration.getText()), Double.parseDouble(textFieldPrice.getText()),
                textFieldActors.getText(), textFieldDescription.getText(), coverPath.getText(),textFieldAgeLimit.getText(),textFieldGenre.getText(),textFieldRating.getText()));

        // Setting the scene and the stage
        scene = new Scene(borderPane,600,500);
        window.setScene(scene);
        window.show();
    }
}