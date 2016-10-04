package PresentationLayer;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BookingCustomerScene extends Application {
    private VBox vlabels, vtextfilds;
    private Label namelabel, phoneNo, email;
    private TextField nameTextField, phoneTextField, emailTextField,  ticketTextField;
    private Button bookButton;

    @Override
    public void start(Stage primaryStage) throws Exception {
        namelabel = new Label("Name of the client");
        phoneNo = new Label("Phone number");
        email = new Label("Email");

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
        ticketTextField.setPromptText("Write tickets number here...");
        ticketTextField.setPrefWidth(250);

        bookButton = new Button("Book movie");

        vlabels = new VBox(5);

        vtextfilds = new VBox(5);

    }
}
