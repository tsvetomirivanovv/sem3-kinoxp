package ApplicationLayer;
import ApplicationLayer.DataTypes.Booking;
import ApplicationLayer.DataTypes.Schedule;
import Kino.KinoXP;
import PresentationLayer.HomeScene;
import PresentationLayer.ViewBookingScene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;

import java.time.LocalDate;

import static Kino.KinoXP.window;

public class ViewBookingController {
    public static ObservableList searchBookingsBySchedule(Schedule schedule) {
        ObservableList<Booking> searchBookingList = FXCollections.observableArrayList();
        searchBookingList.clear();

        for (Booking booking : KinoXP.bookingList) {
            if (booking.getSchedule_id() == schedule.getSchedule_id()) {
                searchBookingList.add(booking);
            }
        }

        return searchBookingList;
    }
}
 /*   public static void backToResults(Scene scene){
        KinoXP.window.setScene();
}
*/
