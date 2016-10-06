package ApplicationLayer;

import ApplicationLayer.DataTypes.Movie;
import DataAccessLayer.DBMovies;
import Kino.KinoXP;
import PresentationLayer.AddButtonScene;
import PresentationLayer.HomeScene;
import PresentationLayer.ViewMovieScene;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * Created by Tsvetomir on 9/28/2016.
 */
public class ManageMovieController {

    public void backToHomeScene(){
        // go back to the HomeScene
        HomeScene homeScene = new HomeScene();
        KinoXP.window.setScene(homeScene.setHomeScene());
    }

    public void removeMovie(Movie movie) {
        try {// remove the movie from the global ObservableList and then from DB
            DBMovies dbMovies = new DBMovies();
            KinoXP.movieList.remove(movie);
            dbMovies.remove(movie);
        }
        catch (NullPointerException nullPointer) {
            showAlert();
        }
    }

    public void addMovie() {
        //shows the AddButtonScene with blank fields
        AddButtonScene addButtonScene = new AddButtonScene();
        Movie mov = new Movie();
        addButtonScene.setAddScene(mov, "add");
    }

    public void editMovie(Movie mov) {
        try {//shows the AddButtonScene with populated fields
            AddButtonScene addButtonScene = new AddButtonScene();
            addButtonScene.setAddScene(mov, "edit");
        }
        catch (NullPointerException nullPointer) {
            showAlert();
        }
    }

    public void showInfoScene(Movie movie) {
        try {
            ViewMovieScene viewMovieScene = new ViewMovieScene();
            viewMovieScene.setInfoScene(movie);
        }
        catch (NullPointerException nullPointer) {
            showAlert();
        }
    }

    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("No movie selected!");
        alert.setContentText("Please select a movie.");
        alert.showAndWait();
    }

    public void searchMovie(TableView moviesTableView, TextField searchField){
        FilteredList<Movie> filteredData = new FilteredList<>(moviesTableView.getItems(), p -> true);

        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(movie -> {
                // If filter text is empty, display all movies.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare title of every movie with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (movie.getName().toLowerCase().contains(lowerCaseFilter))
                    return true; // Filter matches title.
                return false; // Does not match.
            });
        });

        // Wrap the FilteredList in a SortedList.
        SortedList<Movie> sortedData = new SortedList<>(filteredData);

        // Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(moviesTableView.comparatorProperty());

        // Add sorted (and filtered) data to the table.
        moviesTableView.setItems(sortedData);
    }
}
