package PresentationLayer;

import ApplicationLayer.AddConsSceneController;
import ApplicationLayer.AddSceneController;
import ApplicationLayer.DataTypes.Consumable;
import ApplicationLayer.DataTypes.Movie;
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

/**
 * Created by flexl on 06-10-2016.
 */
public class AddConsButtonScene {

    private Stage window;
    private BorderPane borderPane;
    private Scene scene;
    private VBox vBoxLabel, vBoxTextField;
    private HBox hBox, hBoxButton;
    private Label name, price;
    private TextField textFieldName, textFieldPrice;
    private Button confirmButton;
    private Consumable consumable;


    public void setAddScene(Consumable con, String addOrEdit) {
        window = new Stage();

        // Initializing the Labels, Buttons and stuff
        borderPane = new BorderPane();
        borderPane.setPadding(new Insets(20, 40, 40, 40));
        vBoxLabel = new VBox(20);
        vBoxLabel.setPadding(new Insets(40, 40, 40, 40)); // LABEL VBOX
        vBoxTextField = new VBox(9);
        vBoxTextField.setPadding(new Insets(40, 40, 40, 40)); // TEXTFIELD VBOX

        hBoxButton = new HBox(10); // BUTTON HBOX
        hBox = new HBox(); // MAIN HBOX

        name = new Label("Name: ");
        textFieldName = new TextField();
        textFieldName.setPromptText("Write name here ... ");

        price = new Label("Price: ");
        textFieldPrice = new TextField();
        textFieldPrice.setPromptText("Write price here ...");

        confirmButton = new Button("OK");

        vBoxLabel.getChildren().addAll(name, price); // LABELS VBOX
        vBoxTextField.getChildren().addAll(textFieldName, textFieldPrice); // TEXTFIELDS VBOX

        hBox.getChildren().addAll(vBoxLabel, vBoxTextField);
        hBoxButton.getChildren().addAll(confirmButton);
        hBoxButton.setAlignment(Pos.BOTTOM_RIGHT);

        borderPane.setCenter(hBox);
        borderPane.setBottom(hBoxButton);

        // make an instantiation of the Controller
        AddConsSceneController addConsController = new AddConsSceneController();

        //setting the consumable
        setConsumable(con);
        String holdName = consumable.getName(); //this will hold the current movie_name to be used in the database update() method

        confirmButton.setOnAction(event -> { //sets the action based on functionality needed (add/edit)
            //get the modified fields for the movie
            consumable.setName(textFieldName.getText());
            consumable.setPrice(Double.parseDouble(textFieldPrice.getText()));

            switch (addOrEdit) {
                case "add":
                    addConsController.addConsumable(consumable);
                    window.close();
                    break;

                case "edit":
                    addConsController.editConsumable(consumable, holdName);
                    window.close();
                    break;
            }
        });

        // Setting the scene and the stage
        scene = new Scene(borderPane, 620, 500);
        scene.getStylesheets().add("CSS");
        window.setScene(scene);
        window.show();
    }


    //method to set the movie of which details are displayed
    public void setConsumable(Consumable cons) {
        consumable = cons;

        textFieldName.setText(consumable.getName());
        textFieldPrice.setText(Double.toString(consumable.getPrice()));
    }
}
