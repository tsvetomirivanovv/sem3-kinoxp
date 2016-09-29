package ApplicationLayer.DataTypes;

import javafx.beans.property.*;

/**
 * Created by Dana on 28-Sep-16.
 */
public class Movie {

    private StringProperty name;
    private IntegerProperty duration;
    private DoubleProperty price;
    private StringProperty actors;
    private StringProperty description;
    private StringProperty coverPath;
    private StringProperty ageLimit;
    private StringProperty genre;
    private StringProperty rating;

    public Movie() {
        this.name = new SimpleStringProperty("");
        this.duration = new SimpleIntegerProperty(0);
        this.price = new SimpleDoubleProperty(0);
        this.actors = new SimpleStringProperty("");
        this.description = new SimpleStringProperty("");
        this.coverPath = new SimpleStringProperty("\\");
        this.ageLimit = new SimpleStringProperty("");
        this.genre = new SimpleStringProperty("");
        this.rating = new SimpleStringProperty("");
    }

    public Movie(String name, int duration, double price, String actors,
                 String description, String coverPath, String ageLimit,
                 String genre, String rating) {
        this.name = new SimpleStringProperty(name);
        this.duration = new SimpleIntegerProperty(duration);
        this.price = new SimpleDoubleProperty(price);
        this.actors = new SimpleStringProperty(actors);
        this.description = new SimpleStringProperty(description);
        this.coverPath = new SimpleStringProperty(coverPath);
        this.ageLimit = new SimpleStringProperty(ageLimit);
        this.genre = new SimpleStringProperty(genre);
        this.rating = new SimpleStringProperty(rating);
    }

    // GETTERS

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getRating() {
        return rating.get();
    }

    public void setRating(String rating) {
        this.rating = new SimpleStringProperty(rating);
    }

    public StringProperty ratingProperty() {
        return rating;
    }

    public int getDuration() {
        return duration.get();
    }

    public void setDuration(int duration) {
        this.duration = new SimpleIntegerProperty(duration);
    }

    public IntegerProperty durationProperty() {
        return duration;
    }

    public double getPrice() {
        return price.get();
    }

    public void setPrice(double price) {
        this.price = new SimpleDoubleProperty(price);
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    public String getActors() {
        return actors.get();
    }

    public void setActors(String actors) {
        this.actors = new SimpleStringProperty(actors);
    }

    public StringProperty actorsProperty() {
        return actors;
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description = new SimpleStringProperty(description);
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    // SETTERS

    public String getCoverPath() {
        return coverPath.get();
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = new SimpleStringProperty(coverPath);
    }

    public StringProperty coverPathProperty() {
        return coverPath;
    }

    public String getAgeLimit() {
        return ageLimit.get();
    }

    public void setAgeLimit(String ageLimit) {
        this.ageLimit = new SimpleStringProperty(ageLimit);
    }

    public StringProperty ageLimitProperty() {
        return ageLimit;
    }

    public String getGenre() {
        return genre.get();
    }

    public void setGenre(String genre) {
        this.genre = new SimpleStringProperty(genre);
    }

    public StringProperty genreProperty() {
        return genre;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name=" + name.getValue() +
                ", duration=" + duration.getValue() +
                ", price=" + price.getValue() +
                ", actors=" + actors.getValue() +
                ", description=" + description.getValue() +
                ", coverPath=" + coverPath.getValue() +
                ", ageLimit=" + ageLimit.getValue() +
                ", genre=" + genre.getValue() +
                ", rating=" + rating.getValue() +
                '}';
    }
}

