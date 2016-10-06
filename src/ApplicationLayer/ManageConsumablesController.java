package ApplicationLayer;

import ApplicationLayer.DataTypes.Booking;
import ApplicationLayer.DataTypes.Consumable;
import ApplicationLayer.DataTypes.Movie;
import ApplicationLayer.DataTypes.Schedule;
import DataAccessLayer.DBBookings;
import DataAccessLayer.DBMovies;
import DataAccessLayer.DBSchedules;
import Kino.KinoXP;
import PresentationLayer.AddButtonScene;
import PresentationLayer.AddConsButtonScene;
import PresentationLayer.HomeScene;
import PresentationLayer.ViewMovieScene;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.Iterator;

/**
 * Created by flexl on 06-10-2016.
 */
public class ManageConsumablesController {

    public void backToHomeScene(){
        // go back to the HomeScene
        HomeScene homeScene = new HomeScene();
        KinoXP.window.setScene(homeScene.setHomeScene());
    }

    public void addConsumable() {
        //shows the AddButtonScene with blank fields
        AddConsButtonScene addConsButtonScene = new AddConsButtonScene();
        Consumable consumable = new Consumable();
        addConsButtonScene.setAddScene(consumable, "add");
    }

    public void editConsumable(Consumable consumable) {
        try {//shows the AddButtonScene with populated fields
            AddConsButtonScene addConsButtonScene = new AddConsButtonScene();
            addConsButtonScene.setAddScene(consumable, "edit");
        }
        catch (NullPointerException nullPointer) {
            showAlert();
        }
    }

    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("No consumable selected!");
        alert.setContentText("Please select a consumable.");
        alert.showAndWait();
    }
}
