package DataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Tsvetomir on 9/28/2016.
 */
public class Database {
    private static Connection conn = null;

    public void connectDatabase(){
        System.out.println("-------- MySQL JDBC Connection Testing ------------");

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            return;
        }

        System.out.println("MySQL JDBC Driver Registered!");

        try {
            conn = DriverManager
                    .getConnection(Authentication.getDbUrl(), Authentication.getDbUser(), Authentication.getDbPass());
        } catch (SQLException e) {
            System.out.println("Connection Failed! Loading from XML Sheets? Or Try to Create the Tables from Here Later");
            e.printStackTrace();
            return;
        }
        if (conn != null) {
            System.out.println("Great Success! DB is Connected");
        } else {
            System.out.println("Failed to make connection!");
        }
    }
    public static Connection getConn() {
        return conn;
    }
}
