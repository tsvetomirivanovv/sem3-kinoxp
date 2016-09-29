package ApplicationLayer;

import ApplicationLayer.DataTypes.Movie;
import DataAccessLayer.DBMovies;
import Kino.KinoXP;
import PresentationLayer.AddButtonScene;
import PresentationLayer.ViewMovieScene;

/**
 * Created by Tsvetomir on 9/28/2016.
 */
public class ManageMovieController {

    public static void removeMovie(Movie movie) {
        // remove the movie from the global ObservableList and then from DB
        DBMovies dbMovies = new DBMovies();
        KinoXP.movieList.remove(movie);
        dbMovies.remove(movie);
    }

    public void addMovie() {
        //shows the AddButtonScene with blank fields
        AddButtonScene addButtonScene = new AddButtonScene();
        Movie mov = new Movie();
        addButtonScene.setAddScene(mov, "add");
    }

    public void editMovie(Movie mov) {
        //shows the AddButtonScene with populated fields
        AddButtonScene addButtonScene = new AddButtonScene();
        addButtonScene.setAddScene(mov, "edit");
    }

    public void showInfoScene(Movie movie) {
        ViewMovieScene viewMovieScene = new ViewMovieScene();
        viewMovieScene.setInfoScene(movie);
    }
}
