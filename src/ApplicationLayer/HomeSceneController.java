package ApplicationLayer;

import ApplicationLayer.DataTypes.Movie;
import Kino.KinoXP;
import PresentationLayer.ManageMovieScene;
import PresentationLayer.ResultsMovieScene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

/**
 * Created by Andrei on 28/09/2016.
 */
public class HomeSceneController {

    private ManageMovieScene manageMovieScene = new ManageMovieScene();
    private ResultsMovieScene resultsMovieScene = new ResultsMovieScene();

    public void changeScene(String scene, LocalDate date) {
        if(scene.equals("manage")) {
            KinoXP.window.setScene(manageMovieScene.setManageMovieScene());
        } else if (scene.equals("results")) {
            KinoXP.window.setScene(resultsMovieScene.setResultsMovieScene(date));
        }
    }
}
