package Kino;

import DataAccessLayer.Database;
import PresentationLayer.HomeScene;
import PresentationLayer.ManageMovieScene;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.*;

/**
 * Created by Tsvetomir on 9/28/2016.
 */
public class KinoXP extends Application {

    public static Stage window;

    public static ArrayList<Object> movieList;

    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;

        // connect to Database
        Database DB;
        DB = new Database();
        DB.connectDatabase();

        // make an instantiation of the class HomeScene
        HomeScene homeScene = new HomeScene();
        ManageMovieScene manageMovieScene = new ManageMovieScene();

        window.setTitle("KinoXP");
        window.setScene(homeScene.setHomeScene());
        //window.setScene(manageMovieScene.setManageMovieScene());
        window.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
