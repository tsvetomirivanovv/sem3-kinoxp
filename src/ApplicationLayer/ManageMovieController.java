package ApplicationLayer;

import ApplicationLayer.DataTypes.Booking;
import ApplicationLayer.DataTypes.Movie;
import ApplicationLayer.DataTypes.Schedule;
import DataAccessLayer.DBBookings;
import DataAccessLayer.DBMovies;
import DataAccessLayer.DBSchedules;
import Kino.KinoXP;
import PresentationLayer.AddButtonScene;
import PresentationLayer.HomeScene;
import PresentationLayer.ViewMovieScene;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.Iterator;
import java.util.Optional;

public class ManageMovieController {

    //buttons actions
    public void backToHomeScene() {
        // go back to the HomeScene
        HomeScene homeScene = new HomeScene();
        KinoXP.window.setScene(homeScene.setHomeScene());
    }

    public void removeMovie(Movie movie) {
        //confirmation alert
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setHeaderText("Remove movie");
        confirmAlert.setContentText("Are you sure you want to remove \"" + movie.getName() + "\"?");

        Optional<ButtonType> result = confirmAlert.showAndWait();

        if (result.get() == ButtonType.OK) { //confirmed
            try {// remove the movie from the global ObservableList and then from DB
                Iterator<Schedule> scheduleIterator = KinoXP.scheduleList.iterator();

                DBSchedules dbSchedule = new DBSchedules();
                DBBookings dbBooking = new DBBookings();
                DBMovies dbMovies = new DBMovies();

                while (scheduleIterator.hasNext()) {
                    Iterator<Booking> bookingIterator = KinoXP.bookingList.iterator();
                    Schedule schedule = scheduleIterator.next();
                    //find the schedule that has the same movie id as the movie that needs to be removed
                    if (schedule.getMovie_id() == movie.getMovie_id()) {

                        //find the booking that has the same schedule id as that schedule
                        while (bookingIterator.hasNext()) {
                            Booking booking = bookingIterator.next();
                            if (booking.getSchedule_id() == schedule.getSchedule_id()) {
                                bookingIterator.remove();  //remove all bookings that have that schedule id
                                dbBooking.remove(booking);
                            }
                        }
                        scheduleIterator.remove(); //remove all schedules that have that movie id
                        dbSchedule.remove(schedule);
                    }
                }

                KinoXP.movieList.remove(movie); //finally remove the selected movie
                dbMovies.remove(movie);

            } catch (NullPointerException nullPointer) {
                showAlert();
            }

        } else {
            confirmAlert.close();
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
        } catch (NullPointerException nullPointer) {
            showAlert();
        }
    }

    public void showInfoScene(Movie movie) {
        try {
            ViewMovieScene viewMovieScene = new ViewMovieScene();
            viewMovieScene.setInfoScene(movie);
        } catch (NullPointerException nullPointer) {
            showAlert();
        }
    }

    //no movie selected
    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("No movie selected!");
        alert.setContentText("Please select a movie.");
        alert.showAndWait();
    }


    //search field functionality
    public void searchMovie(TableView moviesTableView, TextField searchField) {
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
