package ApplicationLayer;

import ApplicationLayer.DataTypes.Booking;
import DataAccessLayer.DBBookings;
import Kino.KinoXP;

/**
 * Created by Andrei on 10/4/2016.
 */
public class BookingCustomerController {
    public void addBooking(Booking booking) {
        // add the new movie to the global ObservableList and DB
        KinoXP.bookingList.add(booking);
        DBBookings dbBookings = new DBBookings();
        dbBookings.insert(booking);
    }

    public void editBooking(Booking booking) {
        int listIndex = KinoXP.bookingList.indexOf(booking); // holds the index of the booking in the ObbArrayList

        KinoXP.bookingList.set(listIndex, booking); // updates the arraylist
        DBBookings dbBookings = new DBBookings();
        dbBookings.update(booking);
    }

}
