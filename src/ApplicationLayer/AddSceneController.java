package ApplicationLayer;

import ApplicationLayer.DataTypes.Movie;
import DataAccessLayer.DBMovies;
import Kino.KinoXP;

/**
 * Created by Andrei on 29/09/2016.
 */
public class AddSceneController {

    public void addMovie(Movie movie) {
        // add the new movie to the global ObservableList and DB
        KinoXP.movieList.add(movie);
        DBMovies dbMovies = new DBMovies();
        dbMovies.insert(movie);
    }

    public void editMovie(Movie movie, String holdName) {
        int listIndex = KinoXP.movieList.indexOf(movie); //holds the index in the ObsArrayList

        KinoXP.movieList.set(listIndex, movie); //update the arraylist
        DBMovies dbMovies = new DBMovies();
        dbMovies.update(movie, holdName);
    }
}
