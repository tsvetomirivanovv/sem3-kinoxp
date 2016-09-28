package ApplicationLayer.DataTypes;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Dana on 28-Sep-16.
 */
public class Movie {

    private StringProperty name;
    private IntegerProperty duration;
    private IntegerProperty price;
    private StringProperty actors;
    private StringProperty description;
    private StringProperty coverPath;
    private StringProperty ageLimit;
    private StringProperty genre;
    private StringProperty rating;

    public Movie() {

    }

    public Movie(String name, int duration, int price, String actors,
                 String description, String coverPath, String ageLimit,
                 String genre, String rating) {
        this.name = new SimpleStringProperty(name);
        this.duration = new SimpleIntegerProperty(duration);
        this.price = new SimpleIntegerProperty(price);
        this.actors = new SimpleStringProperty(actors);
        this.description = new SimpleStringProperty(description);
        this.coverPath = new SimpleStringProperty(coverPath);
        this.ageLimit = new SimpleStringProperty(ageLimit);
        this.genre = new SimpleStringProperty(genre);
        this.rating = new SimpleStringProperty(rating);
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

    public String getRating() {
        return rating.get();
    }

    public StringProperty ratingProperty() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating.set(rating);
    }

    public int getDuration() {
        return duration.get();
    }

    public IntegerProperty durationProperty() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration.set(duration);
    }

    public int getPrice() {
        return price.get();
    }

    public IntegerProperty priceProperty() {
        return price;
    }

    public void setPrice(int price) {
        this.price.set(price);
    }

    public String getActors() {
        return actors.get();
    }

    public StringProperty actorsProperty() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors.set(actors);
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getCoverPath() {
        return coverPath.get();
    }

    public StringProperty coverPathProperty() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath.set(coverPath);
    }

    public String getAgeLimit() {
        return ageLimit.get();
    }

    public StringProperty ageLimitProperty() {
        return ageLimit;
    }

    public void setAgeLimit(String ageLimit) {
        this.ageLimit.set(ageLimit);
    }

    public String getGenre() {
        return genre.get();
    }

    public StringProperty genreProperty() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre.set(genre);
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

