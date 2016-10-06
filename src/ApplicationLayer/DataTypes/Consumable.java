package ApplicationLayer.DataTypes;

import javafx.beans.property.*;

/**
 * Created by Petru on 06-Oct-16.
 */
public class Consumable {
    //fields
    private IntegerProperty id;
    private StringProperty name;
    private DoubleProperty price;


    //constructor
    public Consumable() {
        this.id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty("");
        this.price = new SimpleDoubleProperty(0.0);
    }

    public Consumable(int id, String name, double price) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
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

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public double getPrice() {
        return price.get();
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    public void setPrice(double price) {
        this.price.set(price);
    }


    //toString
    @Override
    public String toString() {
        return "Consumable{" +
                "id=" + id +
                ", name=" + name +
                ", price=" + price +
                '}';
    }
}
