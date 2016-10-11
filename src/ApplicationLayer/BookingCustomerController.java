package ApplicationLayer;

import ApplicationLayer.DataTypes.Booking;
import DataAccessLayer.DBBookings;
import Kino.KinoXP;

public class BookingCustomerController {
    public void addBooking(Booking booking) {
        // add the new movie to the global ObservableList and DB
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
