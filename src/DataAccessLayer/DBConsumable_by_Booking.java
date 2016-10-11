package DataAccessLayer;

import ApplicationLayer.DataTypes.Consumable_by_Booking;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Petru on 06-Oct-16.
 */
public class DBConsumable_by_Booking {
    //gets connection from database class
    private static Connection conn = Database.getConn();
    private static Statement stmt = null;

    public ObservableList readAll() {
        ObservableList<Consumable_by_Booking> consumable_by_bookingS = FXCollections.observableArrayList();
        consumable_by_bookingS.clear();
        try {
            String sql = "SELECT * FROM consum_by_booking";

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Consumable_by_Booking consumable_by_booking = new Consumable_by_Booking();
                consumable_by_booking.setId(rs.getInt("id"));
                consumable_by_booking.setConsumable_id(rs.getInt("consumable_id"));
                consumable_by_booking.setBooking_id(rs.getInt("booking_id"));
                consumable_by_booking.setQuantity(rs.getInt("qty"));

                consumable_by_bookingS.add(consumable_by_booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consumable_by_bookingS;
    }

    public void insert(Consumable_by_Booking consumable_by_booking) {

        try {
            stmt = conn.createStatement();
            String sql = "insert into consum_by_booking values\n" +
                    "(default, '" + consumable_by_booking.getId() + "', " + consumable_by_booking.getConsumable_id() +
                    "', " + consumable_by_booking.getBooking_id() + "', " + consumable_by_booking.getQuantity() + ");";

            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void update(Consumable_by_Booking consumable_by_booking) {
        try {
            stmt = conn.createStatement();
            String sql = "UPDATE consum_by_booking SET id = " + consumable_by_booking.getId() +
                    ", consumable_id = '" + consumable_by_booking.getConsumable_id() + "', booking_id = " + consumable_by_booking.getBooking_id() +
                    "', qty = " + consumable_by_booking.getQuantity() +
                    " WHERE id = " + consumable_by_booking.getId() + ";";

            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void remove(Consumable_by_Booking consumable_by_booking) {

        try {
            stmt = conn.createStatement();
            String sql = "delete from consum_by_booking where id = \"" + consumable_by_booking.getId() + "\";";

            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
