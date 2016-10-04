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
public class ResultsMovieController {
    public ObservableList searchMoviesByDate(LocalDate date) {
        ObservableList<Movie> newList = FXCollections.observableArrayList();

        //for(Movie movie : KinoXP.movieList) {
        // TO DO loop in the scheduled movie lists and filter by the date.
        //}

        return newList;
    }
}
