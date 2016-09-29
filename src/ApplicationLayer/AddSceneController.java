package ApplicationLayer;

import ApplicationLayer.DataTypes.Movie;
import DataAccessLayer.DBMovies;
import Kino.KinoXP;

/**
 * Created by Andrei on 29/09/2016.
 */
public class AddSceneController {

    /*textFieldName.getText(), Integer.parseInt(textFieldDuration.getText()), Double.parseDouble(textFieldPrice.getText()),
            textFieldActors.getText(), textFieldDescription.getText(), coverPath.getText(),textFieldAgeLimit.getText(),textFieldGenre.getText(),textFieldRating.getText())*/
    public void saveData(String name, int duration, double price, String actors, String description, String cover, String age, String genre, String rating) {
        Movie movie = new Movie(name, duration, price, actors, description, cover, age, genre, rating);

        KinoXP.movieList.add(movie);
        DBMovies dbMovies = new DBMovies();
        dbMovies.insert(movie);


    }
}
