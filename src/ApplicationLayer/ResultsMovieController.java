package ApplicationLayer;

import ApplicationLayer.DataTypes.Schedule;
import Kino.KinoXP;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

/**
 * Created by Andrei on 28/09/2016.
 */
public class ResultsMovieController {
    public ObservableList searchMoviesByDate(LocalDate date) {
        ObservableList<Schedule> newList = FXCollections.observableArrayList();
        newList.clear();

        for(Schedule schedule : KinoXP.scheduleList) {
            if(schedule.getSchedule_date().equals(date.toString())) {
                newList.add(schedule);
            }
        }

        return newList;
    }
}
