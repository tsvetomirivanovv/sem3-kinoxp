package PresentationLayer;

import ApplicationLayer.DataTypes.Booking;
import ApplicationLayer.DataTypes.Schedule;
import ApplicationLayer.HomeSceneController;
import ApplicationLayer.ViewBookingController;
import DataAccessLayer.DBBookings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.time.LocalDate;

/**
 * Created by Admin on 10/6/16.
 */
public class ViewBookingScene {
    public static TableView<Booking> bookingsTableView;
    private static Scene viewBookingScene;
    public ObservableList<Booking> bookingList = FXCollections.observableArrayList();
    private BorderPane root;
    private Button editButton, removeButton, backButton;
    private TableColumn<Booking, Integer> bookingColumn;
    /*private TableColumn<Booking, Integer> movieColumn;*/
    private TableColumn<Booking, String> nameColumn;
    private TableColumn<Booking, Integer> ticketColumn;

    public static Scene getViewBookingScene() {
        return viewBookingScene;
    }

    public Scene setViewBookingScene(Schedule schedule, LocalDate date) throws Exception {
        editButton = new Button("Edit");
        editButton.setPrefSize(100, 30);
        removeButton = new Button("Remove");
        removeButton.setPrefSize(100, 30);
        backButton = new Button("Back");
        backButton.setPrefSize(100, 30);
        bookingsTableView = new TableView<>();
        bookingsTableView.setPrefHeight(435);
        bookingList = ViewBookingController.searchBookingsBySchedule(schedule);
        bookingsTableView.itemsProperty().setValue(bookingList);
        bookingColumn = new TableColumn<>("ID");
        bookingColumn.setMinWidth(120);
            /*movieColumn = new TableColumn<>("Movie");
            movieColumn.setMinWidth(120);*/
        nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(120);
        ticketColumn = new TableColumn<>("Tickets");
        ticketColumn.setMinWidth(120);

        bookingColumn.setCellValueFactory(new PropertyValueFactory<>("booking_id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("full_name"));
        ticketColumn.setCellValueFactory(new PropertyValueFactory<>("num_of_tickets"));

        bookingsTableView.getColumns().addAll(bookingColumn, nameColumn, ticketColumn);
        bookingsTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        HBox buttonHBox = new HBox(20, backButton, editButton, removeButton);
        buttonHBox.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(30, bookingsTableView, buttonHBox);
        root = new BorderPane();
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setCenter(vBox);

        viewBookingScene = new Scene(root, 700, 500);
        viewBookingScene.getStylesheets().add("CSS");
        root = new BorderPane();
        root.setCenter(vBox);
        viewBookingScene = new Scene(root, 700, 500);
        // make an instantiation of the Controller
        ViewBookingController viewBookingController = new ViewBookingController();
        HomeSceneController homeSceneController = new HomeSceneController();

        // make functionality for the buttons
        backButton.setOnAction(event -> {
            ResultsMovieScene resultsMovieScene = new ResultsMovieScene();
            homeSceneController.changeScene("results", date);
        });
        removeButton.setOnAction(event -> {
            DBBookings dbBookings = new DBBookings();
            ViewBookingController.removeBooking(bookingsTableView.getSelectionModel().getSelectedItem());
            bookingList.remove(bookingsTableView.getSelectionModel().getSelectedItem());
        });
        editButton.setOnAction(event -> {
            BookingCustomerScene bookingCustomerScene = new BookingCustomerScene();
            bookingCustomerScene.setBookingScene(bookingsTableView.getSelectionModel().getSelectedItem(), "edit");

        });
        viewBookingScene.getStylesheets().add("CSS");
        return viewBookingScene;
    }

}

