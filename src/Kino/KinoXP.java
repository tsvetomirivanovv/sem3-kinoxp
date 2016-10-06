package Kino;

import ApplicationLayer.DataTypes.Booking;
import ApplicationLayer.DataTypes.Consumable;
import ApplicationLayer.DataTypes.Movie;
import ApplicationLayer.DataTypes.Schedule;
import DataAccessLayer.*;
import PresentationLayer.HomeScene;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

/**
 * Created by Tsvetomir on 9/28/2016.
 */
public class KinoXP extends Application {

    public static Stage window;

    // global list for storing data from Database
    public static ObservableList<Movie> movieList;
    public static ObservableList<Schedule> scheduleList;
    public static ObservableList<Booking> bookingList;
    public static ObservableList<Consumable> consumableList;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        // connect to Database
        Database DB = new Database();
        DB.connectDatabase();

        // fill all ArrayLists with data from the Database
        fillArrayLists();

        // make an instantiation of the class HomeScene
        HomeScene homeScene = new HomeScene();
        window.setTitle("KinoXP");
        window.setScene(homeScene.setHomeScene());
        window.show();

    }

    public void fillArrayLists() {

        DBMovies dbMovies = new DBMovies();
        DBSchedules dbSchedules = new DBSchedules();
        DBBookings dbBookings = new DBBookings();
        DBConsumables dbConsumables = new DBConsumables();

        movieList = dbMovies.readAll();
        scheduleList = dbSchedules.readAll();
        bookingList = dbBookings.readAll();
        consumableList = dbConsumables.readAll();

    }

}
