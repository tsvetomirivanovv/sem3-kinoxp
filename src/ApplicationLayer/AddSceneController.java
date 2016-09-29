package ApplicationLayer;

import ApplicationLayer.DataTypes.Movie;
import DataAccessLayer.DBMovies;
import Kino.KinoXP;

/**
 * Created by Andrei on 29/09/2016.
 */
public class AddSceneController {

    public void saveData(String name, int duration, double price, String actors, String description,
                         String cover, String age, String genre, String rating) {
        // create a new movie
        Movie movie = new Movie(name, duration, price, actors,
                description, cover, age, genre, rating);

        // add the new movie to the global ObservableList and DB
        KinoXP.movieList.add(movie);
        DBMovies dbMovies = new DBMovies();
        dbMovies.insert(movie);
    }
}
