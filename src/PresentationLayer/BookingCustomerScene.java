package PresentationLayer;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BookingCustomerScene extends Application {
    private VBox vlabels, vtextfilds;
    private Label namelabel, phoneNo, email;
    private TextField nameTextField, phoneTextField, emailTextField,  ticketTextField;


    @Override
    public void start(Stage primaryStage) throws Exception {
         namelabel = new Label("Name of the client");
         phoneNo = new Label("Phone number");
         email = new Label("Email");

         nameTextField = new TextField();
        nameTextField.setPromptText("Write name here...");

        phoneTextField = new TextField();
        phoneTextField.setPromptText("Write phone number here...");

        emailTextField = new TextField();
        emailTextField.setPromptText("Write email here...");

        //un comment
        ticketTextField = new TextField();
        ticketTextField.setPromptText("Write tickets number here...");

        

    }
}
