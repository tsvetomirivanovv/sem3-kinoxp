package PresentationLayer;

import ApplicationLayer.BookingCustomerController;
import ApplicationLayer.DataTypes.Booking;
import ApplicationLayer.DataTypes.Schedule;
import ApplicationLayer.ResultsMovieController;
import Kino.KinoXP;
import javafx.geometry.Insets;
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

import java.time.LocalDate;

public class ResultsMovieScene {

    //fields
    public static TableView<Schedule> moviesTableView;
    ResultsMovieController resultsMovieController = new ResultsMovieController();
    BookingCustomerScene bookingCustomerScene = new BookingCustomerScene();
    BookingCustomerController bookingCustomerController = new BookingCustomerController();
    private Scene manageMovieScene;
    private BorderPane root;
    private Button manageBookingButton, backButton, createBookingButton;
    private TableColumn<Schedule, Integer> scheduleIdColumn;
    private TableColumn<Schedule, String> movieNameColumn;
    private TableColumn<Schedule, Integer> roomColumn;
    private TableColumn<Schedule, String> timeColumn;
    private TableColumn<Schedule, Integer> totalTicketsColumn;
    private Booking booking;

    //initialize the scene
    public Scene setResultsMovieScene(LocalDate date) {
        booking = new Booking();
        createBookingButton = new Button("Create booking");
        createBookingButton.setPrefSize(200, 30);
        manageBookingButton = new Button("Manage bookings");
        manageBookingButton.setPrefSize(200, 30);
        backButton = new Button("Back");
        backButton.setPrefSize(70, 30);

        moviesTableView = new TableView<>();
        moviesTableView.setPrefHeight(435);
        moviesTableView.itemsProperty().setValue(resultsMovieController.searchMoviesByDate(date));
        moviesTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        scheduleIdColumn = new TableColumn<>("Schedule id");
        scheduleIdColumn.setMinWidth(120);
        movieNameColumn = new TableColumn<>("Movie name");
        movieNameColumn.setMinWidth(120);
        roomColumn = new TableColumn<>("Room no");
        roomColumn.setMinWidth(120);
        timeColumn = new TableColumn<>("Time");
        timeColumn.setMinWidth(120);
        totalTicketsColumn = new TableColumn<>("Total tickets");
        totalTicketsColumn.setMinWidth(120);

        scheduleIdColumn.setCellValueFactory(new PropertyValueFactory<>("schedule_id"));
        movieNameColumn.setCellValueFactory(new PropertyValueFactory<>("movie_name"));
        roomColumn.setCellValueFactory(new PropertyValueFactory<>("room"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("schedule_time"));
        totalTicketsColumn.setCellValueFactory(new PropertyValueFactory<>("total_tickets"));
        moviesTableView.getColumns().addAll(scheduleIdColumn, movieNameColumn, roomColumn, timeColumn, totalTicketsColumn);

        Label selectedDateLabel = new Label("Selected date: ");
        selectedDateLabel.setFont(Font.font(null, FontWeight.BOLD, 16));
        Label selectedDateValue = new Label(date.toString());
        selectedDateValue.setFont(Font.font(null, 16));

        selectedDateLabel.setId("selectedDateLabel");
        selectedDateValue.setId("selectedDateLabel");

        HBox selectedDateBox = new HBox();
        selectedDateBox.setPadding(new Insets(20, 0, 10, 20));
        selectedDateBox.getChildren().addAll(selectedDateLabel, selectedDateValue);


        Region buttonReg = new Region();
        buttonReg.setPrefWidth(50);

        HBox buttonHBox = new HBox(20, backButton, manageBookingButton, createBookingButton);

        VBox vBox = new VBox(30, selectedDateBox, moviesTableView, buttonHBox);

        root = new BorderPane();
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setCenter(vBox);

        manageMovieScene = new Scene(root, 700, 500);
        manageMovieScene.getStylesheets().add("CSS");

        backButton.setOnAction(e -> resultsMovieController.backToHomeScene());
        manageBookingButton.setOnAction(event -> {
            ViewBookingScene viewBookingScene = new ViewBookingScene();
            try {
                KinoXP.window.setScene(viewBookingScene.setViewBookingScene(moviesTableView.getSelectionModel().getSelectedItem(), date));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


        createBookingButton.setOnAction(event -> bookingCustomerScene.setBookingScene(booking, "add"));

        return manageMovieScene;
    }

    public TableView getTable() {
        return moviesTableView;
    }

}
