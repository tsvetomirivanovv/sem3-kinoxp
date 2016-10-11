package PresentationLayer;

import ApplicationLayer.BookingCustomerController;
import ApplicationLayer.DataTypes.Booking;
import ApplicationLayer.DataTypes.Movie;
import ApplicationLayer.DataTypes.Schedule;
import Kino.KinoXP;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BookingCustomerScene {

    //fields
    ResultsMovieScene resultsMovieScene;
    ViewConsumables viewConsumables;
    private Stage window;
    private BorderPane borderPane;
    private Scene scene;
    private VBox vlabels, vtextfields, vPrice;
    private Label namelabel, phoneNo, email, ticket, totalPrice, totalPriceConsumables, totalPriceMovieConsumables;
    private TextField nameTextField, phoneTextField, emailTextField, ticketTextField;
    private HBox bigH, buttonH;
    private Button bookButton, addConsumable;
    private Booking booking;
    private double moviePrice, ticketTotalPrice;


    //initialize the scene
    public void setBookingScene(Booking book, String addOrEdit) {
        window = new Stage();

        resultsMovieScene = new ResultsMovieScene();

        //initializing the labels, text fields, the button etc.
        namelabel = new Label("Name of the client");
        phoneNo = new Label("Phone number");
        email = new Label("Email");
        ticket = new Label("Ticket");
        totalPrice = new Label("Total price for the tickets: ");
        totalPriceConsumables = new Label("Total Price for Consumables: ");
        totalPriceMovieConsumables = new Label("Total Price for movie tickets + consumables: ");

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

        addConsumable = new Button("Add consumables");

        bookButton = new Button("Book movie");
        buttonH = new HBox(5);
        buttonH.getChildren().addAll(bookButton, addConsumable);
        buttonH.setAlignment(Pos.BOTTOM_LEFT);

        vPrice = new VBox();
        vPrice.getChildren().addAll(totalPrice, totalPriceConsumables, totalPriceMovieConsumables);
        vPrice.setAlignment(Pos.CENTER_LEFT);

        vlabels = new VBox(15);
        vlabels.getChildren().addAll(namelabel, phoneNo, email, ticket);
        vlabels.setAlignment(Pos.CENTER_LEFT);

        vtextfields = new VBox(7);
        vtextfields.getChildren().addAll(nameTextField, phoneTextField, emailTextField, ticketTextField);
        vtextfields.setAlignment(Pos.CENTER_LEFT);

        bigH = new HBox(10);
        bigH.getChildren().addAll(vlabels, vtextfields);
        bigH.setAlignment(Pos.CENTER_LEFT);

        borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10, 10, 10, 10));
        borderPane.setTop(bigH);
        borderPane.setCenter(vPrice);
        borderPane.setBottom(buttonH);

        // make an instantiation of the BookingCustomerController
        BookingCustomerController bccontroler = new BookingCustomerController();
        setBooking(book);

        viewConsumables = new ViewConsumables();


        String name = resultsMovieScene.moviesTableView.getSelectionModel().getSelectedItem().getMovie_name();
        for (Movie movie : KinoXP.movieList) {
            if (movie.getName() == name) {
                moviePrice = movie.getPrice();
            }
        }


        ticketTextField.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                int tickets = Integer.parseInt(ticketTextField.getText());
                ticketTotalPrice = moviePrice * tickets;
                totalPrice.setText("Total price for the tickets: " + ticketTotalPrice);
            }
        });

        addConsumable.setOnAction(e -> {
            try {
                viewConsumables.setViewConsumablesScene(book, ticketTotalPrice, totalPriceConsumables, totalPriceMovieConsumables);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        //set an action for the book button
        bookButton.setOnAction(e -> {
            Schedule schedule = (Schedule) resultsMovieScene.getTable().getSelectionModel().getSelectedItem();
            booking.setSchedule_id(schedule.getSchedule_id());
            booking.setFull_name(nameTextField.getText());
            booking.setEmail(emailTextField.getText());
            booking.setPhone(phoneTextField.getText());
            booking.setNum_of_tickets(Integer.parseInt(ticketTextField.getText()));

            switch (addOrEdit) {
                case "add":
                    bccontroler.addBooking(booking);
                    window.close();
                    break;

                case "edit":
                    bccontroler.editBooking(booking);
                    window.close();
                    break;
            }

        });

        scene = new Scene(borderPane, 430, 280);
        scene.getStylesheets().add("CSS");
        window.setScene(scene);
        window.show();

    }

    //method to set the booking for which details are displayed
    public void setBooking(Booking book) {
        booking = book;

        nameTextField.setText(booking.getFull_name());
        phoneTextField.setText(booking.getPhone());
        emailTextField.setText(booking.getEmail());
        ticketTextField.setText(booking.getNum_of_tickets() + "");

    }

}
