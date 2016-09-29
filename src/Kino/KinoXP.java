package Kino;

import ApplicationLayer.DataTypes.Movie;
import DataAccessLayer.DBMovies;
import DataAccessLayer.Database;
import PresentationLayer.HomeScene;
import PresentationLayer.ManageMovieScene;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by Tsvetomir on 9/28/2016.
 */
public class KinoXP extends Application {

    public static Stage window;

    public static ArrayList<Movie> movieList;

    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;

        // connect to Database
        Database DB = new Database();
        DB.connectDatabase();

        // fill all ArrayLists with data from the Database
        fillArrayLists();

        // make an instantiation of the class HomeScene
        HomeScene homeScene = new HomeScene();
        ManageMovieScene manageMovieScene = new ManageMovieScene();

        window.setTitle("KinoXP");
        window.setScene(homeScene.setHomeScene());
        //window.setScene(manageMovieScene.setManageMovieScene());
        window.show();

    }

    public void fillArrayLists(){
        DBMovies dbMovies = new DBMovies();

        movieList = dbMovies.readAll();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
