package ApplicationLayer.DataTypes;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Andrei on 04/10/2016.
 */
public class Schedule {

    private IntegerProperty schedule_id;
    private IntegerProperty movie_id;
    private StringProperty movie_name;
    private StringProperty schedule_date;  // format of the date: 'YYYY-MM-DD-HH'
    private StringProperty schedule_time;
    private IntegerProperty room;
    private IntegerProperty total_tickets;

    public Schedule(){
        this.schedule_id = new SimpleIntegerProperty();
        this.movie_id = new SimpleIntegerProperty();
        this.movie_name = new SimpleStringProperty();
        this.schedule_date = new SimpleStringProperty();
        this.schedule_time = new SimpleStringProperty();
        this.room = new SimpleIntegerProperty();
        this.total_tickets = new SimpleIntegerProperty();
    }

    public Schedule(int schedule_id, int movie_id, String schedule_date,
                    String schedule_time, int room, int total_tickets){
        this.schedule_id = new SimpleIntegerProperty(schedule_id);
        this.movie_id = new SimpleIntegerProperty(movie_id);
        this.movie_name = new SimpleStringProperty();
        this.schedule_date = new SimpleStringProperty(schedule_date);
        this.schedule_time = new SimpleStringProperty(schedule_time);
        this.room = new SimpleIntegerProperty(room);
        this.total_tickets = new SimpleIntegerProperty(total_tickets);
    }

    // GETTERS

    public String getMovie_name() {
        return movie_name.get();
    }

    public StringProperty movie_nameProperty() {
        return movie_name;
    }

    public String getSchedule_time() {
        return schedule_time.get();
    }

    public StringProperty schedule_timeProperty() {
        return schedule_time;
    }

    public int getSchedule_id() {
        return schedule_id.get();
    }

    public IntegerProperty schedule_idProperty() {
        return schedule_id;
    }

    public int getMovie_id() {
        return movie_id.get();
    }

    public IntegerProperty movie_idProperty() {
        return movie_id;
    }

    public String getSchedule_date() {
        return schedule_date.get();
    }

    public StringProperty schedule_dateProperty() {
        return schedule_date;
    }

    public int getRoom() {
        return room.get();
    }

    public IntegerProperty roomProperty() {
        return room;
    }

    public int getTotal_tickets() {
        return total_tickets.get();
    }

    public IntegerProperty total_ticketsProperty() {
        return total_tickets;
    }

    // SETTERS

    public void setSchedule_time(String schedule_time) {
        this.schedule_time.set(schedule_time);
    }


    public void setMovie_name(String movie_name) {
        this.movie_name.set(movie_name);
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id.set(schedule_id);
    }

    public void setMovie_id(int movie_id) {
        this.movie_id.set(movie_id);
    }

    public void setSchedule_date(String schedule_date) {
        this.schedule_date.set(schedule_date);
    }

    public void setRoom(int room) {
        this.room.set(room);
    }

    public void setTotal_tickets(int total_tickets) {
        this.total_tickets.set(total_tickets);
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "schedule_id=" + schedule_id +
                ", movie_id=" + movie_id +
                ", schedule_date=" + schedule_date +
                ", room=" + room +
                ", total_tickets=" + total_tickets +
                '}';
    }
}
