package PresentationLayer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;


public class AddButtonScene extends Application {
    private BorderPane borderPane;
    private FileChooser coverChooser;
    private File selectedFile;
    private Scene scene;
    private VBox vBoxLabel, vBoxTextField;
    private HBox hBox, hBoxButton;
    private Label name,duration,price,actors,description,cover,agelimit, coverPath;
    private TextField textFieldName, textFieldDuration, textFieldPrice, textFieldActors, textFieldDescription, textFieldAgeLimit;
    private Button chooseFileButton, confirmButton;


    @Override
    public void start(Stage primaryStage) throws Exception {
        borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10,10,10,10));
        vBoxLabel = new VBox(16);
        vBoxLabel.setPadding(new Insets(40,40,40,40)); // LABEL VBOX
        vBoxTextField = new VBox(8);
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



        cover = new Label("Cover: ");
        coverPath = new Label();
        chooseFileButton = new Button("Choose cover image");
        coverChooser = new FileChooser();
        chooseFileButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                selectedFile = coverChooser.showOpenDialog(primaryStage);
                coverPath.setText(selectedFile.toString());

            }
        });
        confirmButton = new Button("Create Movie");

        vBoxLabel.getChildren().addAll(name,duration,price,actors,description,agelimit,cover); // LABELS VBOX
        vBoxTextField.getChildren().addAll(textFieldName,textFieldDuration,textFieldPrice,textFieldActors,textFieldDescription,textFieldAgeLimit,coverPath); // TEXFIELDS VBOX

        hBox.getChildren().addAll(vBoxLabel,vBoxTextField);
        hBoxButton.getChildren().addAll(chooseFileButton,confirmButton);
        hBoxButton.setAlignment(Pos.BOTTOM_RIGHT);

        borderPane.setCenter(hBox);
        borderPane.setBottom(hBoxButton);

        scene = new Scene(borderPane,500,350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
