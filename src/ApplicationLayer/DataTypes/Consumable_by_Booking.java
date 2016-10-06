package ApplicationLayer.DataTypes;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Created by Petru on 06-Oct-16.
 */
public class Consumable_by_Booking {
    //fields
    private IntegerProperty id, booking_id, consumable_id, quantity;

    //constructor
    public Consumable_by_Booking() {
        this.id = new SimpleIntegerProperty(0);
        this.booking_id = new SimpleIntegerProperty(0);
        this.consumable_id = new SimpleIntegerProperty(0);
        this.quantity = new SimpleIntegerProperty(0);
    }

    public Consumable_by_Booking(int id, int booking_id, int consumable_id, int quantity) {
        this.id = new SimpleIntegerProperty(id);
        this.booking_id = new SimpleIntegerProperty(booking_id);
        this.consumable_id = new SimpleIntegerProperty(consumable_id);
        this.quantity = new SimpleIntegerProperty(quantity);
    }


    //getters, setters
    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public int getBooking_id() {
        return booking_id.get();
    }

    public IntegerProperty booking_idProperty() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id.set(booking_id);
    }

    public int getConsumable_id() {
        return consumable_id.get();
    }

    public IntegerProperty consumable_idProperty() {
        return consumable_id;
    }

    public void setConsumable_id(int consumable_id) {
        this.consumable_id.set(consumable_id);
    }

    public int getQuantity() {
        return quantity.get();
    }

    public IntegerProperty quantityProperty() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
    }


    //toString
    @Override
    public String toString() {
        return "Consumable_by_Booking{" +
                "id=" + id +
                ", booking_id=" + booking_id +
                ", consumable_id=" + consumable_id +
                ", quantity=" + quantity +
                '}';
    }
}
