package PresentationLayer;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BookingCustomerScene extends Application {
    private BorderPane borderPane;
    private Scene scene;
    private VBox vlabels, vtextfields;
    private Label namelabel, phoneNo, email, ticket;
    private TextField nameTextField, phoneTextField, emailTextField,  ticketTextField;
    private HBox bigH, buttonH;
    private Button bookButton;

    @Override
    public void start(Stage primaryStage) throws Exception {
        namelabel = new Label("Name of the client");
        phoneNo = new Label("Phone number");
        email = new Label("Email");
        ticket = new Label("Ticket");

        nameTextField = new TextField();
        nameTextField.setPromptText("Write name here...");
        nameTextField.setPrefWidth(250);

        phoneTextField = new TextField();
        phoneTextField.setPromptText("Write phone number here...");
        phoneTextField.setPrefWidth(250);

        emailTextField = new TextField();
        emailTextField.setPromptText("Write email here...");
        emailTextField.setPrefWidth(250);

        ticketTextField = new TextField();
        ticketTextField.setPromptText("Write number of tickets here...");
        ticketTextField.setPrefWidth(250);

        bookButton = new Button("Book movie");
        buttonH = new HBox(5);
        buttonH.getChildren().add(bookButton);
        buttonH.setAlignment(Pos.BOTTOM_RIGHT);

        vlabels = new VBox(15);
        vlabels.getChildren().addAll(namelabel, phoneNo, email, ticket);
        vlabels.setAlignment(Pos.CENTER);

        vtextfields = new VBox(7);
        vtextfields.getChildren().addAll(nameTextField, phoneTextField, emailTextField, ticketTextField);
        vtextfields.setAlignment(Pos.CENTER);
        
        bigH = new HBox(10);
        bigH.getChildren().addAll(vlabels, vtextfields);
        bigH.setAlignment(Pos.CENTER);

        borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10, 10, 10, 10));
        borderPane.setCenter(bigH);
        borderPane.setBottom(buttonH);

        scene = new Scene(borderPane, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
