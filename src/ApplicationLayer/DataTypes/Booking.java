package ApplicationLayer.DataTypes;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Andrei on 04/10/2016.
 */
public class Booking {

    private IntegerProperty booking_id;
    private IntegerProperty schedule_id;
    private StringProperty full_name;
    private StringProperty email;
    private StringProperty phone;
    private IntegerProperty num_of_tickets;

    public Booking(){
        this.booking_id = new SimpleIntegerProperty();
        this.schedule_id = new SimpleIntegerProperty();
        this.full_name = new SimpleStringProperty();
        this.email = new SimpleStringProperty();
        this.phone = new SimpleStringProperty();
        this.num_of_tickets = new SimpleIntegerProperty();
    }

    public Booking(int booking_id, int schedule_id, String full_name,
                   String email, String phone, int num_of_tickets){
        this.booking_id = new SimpleIntegerProperty(booking_id);
        this.schedule_id = new SimpleIntegerProperty(schedule_id);
        this.full_name = new SimpleStringProperty(full_name);
        this.email = new SimpleStringProperty(email);
        this.phone = new SimpleStringProperty(phone);
        this.num_of_tickets = new SimpleIntegerProperty(num_of_tickets);
    }

    // GETTERS

    public int getBooking_id() {
        return booking_id.get();
    }

    public IntegerProperty booking_idProperty() {
        return booking_id;
    }

    public int getSchedule_id() {
        return schedule_id.get();
    }

    public IntegerProperty schedule_idProperty() {
        return schedule_id;
    }

    public String getFull_name() {
        return full_name.get();
    }

    public StringProperty full_nameProperty() {
        return full_name;
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public String getPhone() {
        return phone.get();
    }

    public StringProperty phoneProperty() {
        return phone;
    }

    public int getNum_of_tickets() {
        return num_of_tickets.get();
    }

    public IntegerProperty num_of_ticketsProperty() {
        return num_of_tickets;
    }


    // SETTERS

    public void setBooking_id(int booking_id) {
        this.booking_id.set(booking_id);
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id.set(schedule_id);
    }

    public void setFull_name(String full_name) {
        this.full_name.set(full_name);
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public void setNum_of_tickets(int num_of_tickets) {
        this.num_of_tickets.set(num_of_tickets);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "booking_id=" + booking_id +
                ", schedule_id=" + schedule_id +
                ", full_name=" + full_name +
                ", email=" + email +
                ", phone=" + phone +
                ", num_of_tickets=" + num_of_tickets +
                '}';
    }
}
