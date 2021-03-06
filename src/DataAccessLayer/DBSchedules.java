package DataAccessLayer;

import ApplicationLayer.DataTypes.Movie;
import ApplicationLayer.DataTypes.Schedule;
import Kino.KinoXP;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBSchedules {

    //gets connection from database class
    private static Connection conn = Database.getConn();
    private static Statement stmt = null;

    //get data from database
    public ObservableList readAll() {
        ObservableList<Schedule> schedules = FXCollections.observableArrayList();
        schedules.clear();
        try {
            String sql = "SELECT * FROM schedules";

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Schedule schedule = new Schedule();
                schedule.setSchedule_id(rs.getInt("schedule_id"));
                int movieID = rs.getInt("movie_id");
                schedule.setMovie_id(movieID);
                schedule.setMovie_name(getMovieNameById(movieID));
                String dateTime = rs.getString("schedule_date");
                schedule.setSchedule_date(dateTime.substring(0, 10));
                schedule.setSchedule_time(dateTime.substring(11));
                schedule.setRoom(rs.getInt("room"));
                schedule.setTotal_tickets(rs.getInt("total_tickets"));

                schedules.add(schedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schedules;
    }

    public String getMovieNameById(int movieId) {
        for (Movie movie : KinoXP.movieList) {
            if (movie.getMovie_id() == movieId) {
                return movie.getName();
            }
        }
        return "";
    }

    //insert a new entry tot the database
    public void insert(Schedule schedule) {

        try {
            stmt = conn.createStatement();
            String sql = "insert into schedules values\n" +
                    "(default,\"" + schedule.getMovie_id() + "\",\"" + schedule.getSchedule_date() +
                    "\",\"" + schedule.getRoom() + "\",\"" + schedule.getTotal_tickets() + "\");";
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    //update the database
    public void update(Schedule schedule) {
        try {
            stmt = conn.createStatement();
            String sql = "UPDATE schedules SET movie_id = '" + schedule.getMovie_id() + "', schedule_date = " + schedule.getSchedule_date() +
                    ", room = " + schedule.getRoom() + ", total_tickets = '" + schedule.getTotal_tickets() +
                    "' WHERE schedule_id = '" + schedule.getSchedule_id() + "';";

            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //remove an database entry
    public void remove(Schedule schedule) {

        try {
            stmt = conn.createStatement();
            String sql = "delete from schedules where schedule_id=\"" + schedule.getSchedule_id() + "\"";
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
