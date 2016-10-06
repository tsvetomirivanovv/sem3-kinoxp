package ApplicationLayer;

import ApplicationLayer.DataTypes.Movie;
import Kino.KinoXP;
import PresentationLayer.ManageMovieScene;
import PresentationLayer.ResultsMovieScene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.time.LocalDate;

/**
 * Created by Andrei on 28/09/2016.
 */
public class HomeSceneController {

    private ManageMovieScene manageMovieScene = new ManageMovieScene();
    private ResultsMovieScene resultsMovieScene = new ResultsMovieScene();

    public void changeScene(String scene, LocalDate date) {
        if(scene.equals("manage")) {
            KinoXP.window.setTitle("Manage movies - KinoXP");
            KinoXP.window.setScene(manageMovieScene.setManageMovieScene());

        } else if (scene.equals("results")) {
            try {
                KinoXP.window.setTitle("Scheduled results - KinoXP");
                KinoXP.window.setScene(resultsMovieScene.setResultsMovieScene(date));
            }
            catch (NullPointerException nullPointer) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("No date selected!");
                alert.setContentText("Please select a date.");
                alert.showAndWait();
            }
        }
    }
}
