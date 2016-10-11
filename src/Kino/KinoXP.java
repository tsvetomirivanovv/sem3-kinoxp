package Kino;

import ApplicationLayer.DataTypes.*;
import DataAccessLayer.*;
import PresentationLayer.HomeScene;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

public class KinoXP extends Application {

    public static Stage window;

    // global list for storing data from Database
    public static ObservableList<Movie> movieList;
    public static ObservableList<Schedule> scheduleList;
    public static ObservableList<Booking> bookingList;
    public static ObservableList<Consumable> consumableList;
    public static ObservableList<Consumable_by_Booking> consumable_by_bookings;

    //MAIN
    public static void main(String[] args) {
        launch(args);
    }


    //start method
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        // connect to Database
        Database DB = new Database();
        DB.connectDatabase();

        // fill all ArrayLists with data from the Database
        fillArrayLists();

        // make an instantiation of the class HomeScene
        HomeScene homeScene = new HomeScene();

        //set the window and show it
        window.setTitle("KinoXP");
        window.setScene(homeScene.setHomeScene());
        window.show();

    }

    //get the data from the database
    public void fillArrayLists() {

        DBMovies dbMovies = new DBMovies();
        DBSchedules dbSchedules = new DBSchedules();
        DBBookings dbBookings = new DBBookings();
        DBConsumables dbConsumables = new DBConsumables();
        DBConsumable_by_Booking dbConsumable_by_booking = new DBConsumable_by_Booking();

        movieList = dbMovies.readAll();
        scheduleList = dbSchedules.readAll();
        bookingList = dbBookings.readAll();
        consumableList = dbConsumables.readAll();
        consumable_by_bookings = dbConsumable_by_booking.readAll();

    }

}
