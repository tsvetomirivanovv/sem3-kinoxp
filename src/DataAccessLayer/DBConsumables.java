package DataAccessLayer;

import ApplicationLayer.DataTypes.Booking;
import ApplicationLayer.DataTypes.Consumable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Petru on 06-Oct-16.
 */
public class DBConsumables {
    //gets connection from database class
    private static Connection conn = Database.getConn();
    private static Statement stmt = null;

    public ObservableList readAll() {
        ObservableList<Consumable> consumables = FXCollections.observableArrayList();
        consumables.clear();
        try {
            String sql = "SELECT * FROM consumables";

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Consumable consumable = new Consumable();
                consumable.setId(rs.getInt("consumable_id"));
                consumable.setName(rs.getString("consumable_name"));
                consumable.setPrice(rs.getDouble("consumable_price"));

                consumables.add(consumable);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consumables;
    }

    public void insert(Consumable consumable) {

        try {
            stmt = conn.createStatement();
            String sql = "insert into consumables values\n" +
                    "(default, '" + consumable.getName() + "', " + consumable.getPrice() + ");";

            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void update(Consumable consumable) {
        try {
            stmt = conn.createStatement();
            String sql = "UPDATE consumables SET consumable_id = " + consumable.getId() +
                    ", consumable_name = '" + consumable.getName() + "', consumable_price = " + consumable.getPrice() +
                    " WHERE consumable_id = " + consumable.getId() + ";";

            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void remove(Consumable consumable) {

        try {
            stmt = conn.createStatement();
            String sql = "delete from consumables where consumable_id = \"" + consumable.getId() + "\";";

            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
