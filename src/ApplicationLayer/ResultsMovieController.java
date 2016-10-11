package ApplicationLayer;

import ApplicationLayer.DataTypes.Schedule;
import Kino.KinoXP;
import PresentationLayer.HomeScene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class ResultsMovieController {
    public static void backToHomeScene() {
        // go back to the HomeScene
        HomeScene homeScene = new HomeScene();
        KinoXP.window.setScene(homeScene.setHomeScene());
    }


    //method to return the schedule for a selected date
    public ObservableList<Schedule> searchMoviesByDate(LocalDate date) {
        ObservableList<Schedule> newList = FXCollections.observableArrayList();
        newList.clear();

        for (Schedule schedule : KinoXP.scheduleList) {
            if (schedule.getSchedule_date().equals(date.toString())) {
                newList.add(schedule);
            }
        }

        return newList;
    }
}
