package DataAccessLayer;

import ApplicationLayer.DataTypes.Booking;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBBookings {

    //gets connection from database class
    private static Connection conn = Database.getConn();
    private static Statement stmt = null;


    //get data from database
    public ObservableList readAll() {
        ObservableList<Booking> bookings = FXCollections.observableArrayList();
        bookings.clear();
        try {
            String sql = "SELECT * FROM bookings";

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Booking booking = new Booking();
                booking.setBooking_id(rs.getInt("booking_id"));
                booking.setSchedule_id(rs.getInt("schedule_id"));
                booking.setFull_name(rs.getString("full_name"));
                booking.setEmail(rs.getString("email"));
                booking.setPhone(rs.getString("phone"));
                booking.setNum_of_tickets(rs.getInt("num_of_tickets"));
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }


    //insert a new entry tot the database
    public void insert(Booking booking) {

        try {
            stmt = conn.createStatement();
            String sql = "insert into bookings values\n" +
                    "(default,\"" + booking.getSchedule_id() + "\",\"" + booking.getFull_name() +
                    "\",\"" + booking.getEmail() + "\",\"" + booking.getPhone() + "\",\"" + booking.getNum_of_tickets() + "\");";
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        readAll();
    }

    //update the database
    public void update(Booking booking) {
        try {
            stmt = conn.createStatement();
            String sql = "UPDATE bookings SET schedule_id = '" + booking.getSchedule_id() + "', full_name = '" + booking.getFull_name() + "', email = '" + booking.getEmail() +
                    "', phone='" + booking.getPhone() + "', num_of_tickets = '" + booking.getNum_of_tickets() +
                    "' WHERE booking_id = '" + booking.getBooking_id() + "'";

            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        readAll();
    }


    //remove an database entry
    public void remove(Booking booking) {

        try {
            stmt = conn.createStatement();
            String sql = "delete from bookings where booking_id=\"" + booking.getBooking_id() + "\"";
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        readAll();
    }
}
