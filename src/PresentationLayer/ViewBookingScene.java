package PresentationLayer;
import ApplicationLayer.DataTypes.Booking;
import ApplicationLayer.DataTypes.Movie;
import ApplicationLayer.DataTypes.Schedule;
import ApplicationLayer.HomeSceneController;
import ApplicationLayer.ManageMovieController;
import ApplicationLayer.ResultsMovieController;
import ApplicationLayer.ViewBookingController;
import Kino.KinoXP;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import javax.swing.text.View;
import java.time.LocalDate;

import static Kino.KinoXP.window;

/**
 * Created by Admin on 10/6/16.
 */
public class ViewBookingScene {
        public static ObservableList<Booking> bookingList = FXCollections.observableArrayList();
        public static TableView<Booking> bookingsTableView;
        private static Scene viewBookingScene;
        private BorderPane root;
        private Button addButton, cancelButton, confirmButton,backButton;
        private TableColumn<Booking, Integer> bookingColumn;
        private TableColumn<Booking, Integer> movieColumn;
        private TableColumn<Booking, Integer> scheduleColumn;
        private TableColumn<Booking, String> nameColumn;
        private TableColumn<Booking, Integer> ticketColumn;

        public Scene setViewBookingScene(Schedule schedule, LocalDate date) throws Exception {
            addButton = new Button("Add");
            addButton.setPrefSize(100, 30);
            cancelButton = new Button("Cancel");
            cancelButton.setPrefSize(100, 30);
            confirmButton = new Button("Confirm");
            confirmButton.setPrefSize(100, 30);
            backButton = new Button("Back");
            backButton.setPrefSize(100, 30);
            bookingsTableView = new TableView<>();
            bookingsTableView.setPrefHeight(435);
            bookingsTableView.itemsProperty().setValue(ViewBookingController.searchBookingsBySchedule(schedule));
            bookingColumn = new TableColumn<>("ID");
            bookingColumn.setMinWidth(120);
            movieColumn = new TableColumn<>("Movie");
            movieColumn.setMinWidth(120);
            scheduleColumn = new TableColumn<>("Time");
            scheduleColumn.setMinWidth(120);
            nameColumn = new TableColumn<>("Name");
            nameColumn.setMinWidth(120);
            ticketColumn = new TableColumn<>("Tickets");
            ticketColumn.setMinWidth(120);

            bookingColumn.setCellValueFactory(new PropertyValueFactory<>("booking_id"));
            scheduleColumn.setCellValueFactory(new PropertyValueFactory<>("schedule_id"));
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("full_name"));
            ticketColumn.setCellValueFactory(new PropertyValueFactory<>("num_of_tickets"));

            bookingsTableView.getColumns().addAll(bookingColumn, scheduleColumn, nameColumn, ticketColumn);
            bookingsTableView.setEditable(true);

            HBox buttonHBox = new HBox(20, backButton, addButton, confirmButton, cancelButton);

            VBox vBox = new VBox(30, bookingsTableView, buttonHBox);
            root = new BorderPane();
            root.setPadding(new Insets(20, 20, 20, 20));
            root.setCenter(vBox);

            viewBookingScene = new Scene(root, 700, 500);
            viewBookingScene.getStylesheets().add("CSS");
            root = new BorderPane();
            root.setCenter(vBox);
            viewBookingScene = new Scene(root, 700, 500);
            Booking testBooking = new Booking(10,0,"","","",3);
            bookingList.add(testBooking);

            // make an instantiation of the Controller
            ViewBookingController viewBookingController = new ViewBookingController();
            HomeSceneController homeSceneController = new HomeSceneController();

            // make functionality for the buttons
            backButton.setOnAction(event -> {
                ResultsMovieScene resultsMovieScene = new ResultsMovieScene();
                homeSceneController.changeScene("results", date);
            });




            return viewBookingScene;
        }

    public static Scene getViewBookingScene() {
        return viewBookingScene;
    }

}

