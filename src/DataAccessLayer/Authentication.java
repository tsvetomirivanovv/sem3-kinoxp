package DataAccessLayer;

/**
 * Created by Andrei on 28/09/2016.
 */

/*
    This class is used to connect to the database with your own credentials
    So just replace UserName and UserPass with your own username and password for mysql
 */

public class Authentication {

    public static String DB_URL = "jdbc:mysql://localhost/kinoxp";
    public static String DB_USER = "root";
    public static String DB_PASS = "mysql";

    public static String getDbUrl() {
        return DB_URL;
    }

    public static String getDbUser() {
        return DB_USER;
    }

    public static String getDbPass() {
        return DB_PASS;
    }
}
