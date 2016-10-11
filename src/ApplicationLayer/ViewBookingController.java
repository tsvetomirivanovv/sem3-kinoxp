package ApplicationLayer;

import ApplicationLayer.DataTypes.Booking;
import ApplicationLayer.DataTypes.Consumable_by_Booking;
import ApplicationLayer.DataTypes.Schedule;
import DataAccessLayer.DBBookings;
import DataAccessLayer.DBConsumable_by_Booking;
import Kino.KinoXP;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Iterator;
import java.util.Optional;

import static Kino.KinoXP.bookingList;


public class ViewBookingController {

    public static ObservableList searchBookingsBySchedule(Schedule schedule) {
        ObservableList<Booking> searchBookingList = FXCollections.observableArrayList();
        DBBookings dbBookings = new DBBookings();
        bookingList.clear();
        bookingList = dbBookings.readAll();
        searchBookingList.clear();

        for (Booking booking : KinoXP.bookingList) {
            if (booking.getSchedule_id() == schedule.getSchedule_id()) {
                searchBookingList.add(booking);
            }
        }

        return searchBookingList;
    }

    public static void removeBooking(Booking booking) {
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setHeaderText("Remove booking");
        confirmAlert.setContentText("Are you sure you want to remove this booking?");
        Optional<ButtonType> result = confirmAlert.showAndWait();
        if (result.get() == ButtonType.OK) { //confirmed
            try {// remove the movie from the global ObservableList and then from DB
                Iterator<Consumable_by_Booking> consumable_by_bookingIterator = KinoXP.consumable_by_bookings.iterator();
                DBBookings dbBookings = new DBBookings();
                DBConsumable_by_Booking dbConsumable_by_booking = new DBConsumable_by_Booking();
                while (consumable_by_bookingIterator.hasNext()) {
                    Consumable_by_Booking consumable_by_booking = new Consumable_by_Booking();
                    consumable_by_booking = consumable_by_bookingIterator.next();
                    //find the schedule that has the same movie id as the movie that needs to be removed
                    if (consumable_by_booking.getBooking_id() == booking.getBooking_id()) {
                        consumable_by_bookingIterator.remove(); //remove all schedules that have that movie id
                        dbConsumable_by_booking.remove(consumable_by_booking);
                    }
                }

                KinoXP.bookingList.remove(booking); //finally remove the selected booking
                dbBookings.remove(booking);

            } catch (NullPointerException nullPointer) {
                showAlert();
            }

        } else {
            confirmAlert.close();
        }
    }

    public static void showAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("No movie selected!");
        alert.setContentText("Please select a movie.");
        alert.showAndWait();
    }


}

 /*   public static void backToResults(Scene scene){
        KinoXP.window.setScene();
}
*/
