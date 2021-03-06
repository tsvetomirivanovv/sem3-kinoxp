package ApplicationLayer.DataTypes;

import javafx.beans.property.*;

/**
 * Created by Dana on 28-Sep-16.
 */
public class Movie {

    private IntegerProperty movie_id;
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
        this.movie_id = new SimpleIntegerProperty();
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

    public Movie(int id, String name, int duration, double price, String actors,
                 String description, String coverPath, String ageLimit,
                 String genre, String rating) {
        this.movie_id = new SimpleIntegerProperty(id);
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

    public int getMovie_id() {
        return movie_id.get();
    }

    public IntegerProperty movie_idProperty() {
        return movie_id;
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getRating() {
        return rating.get();
    }

    public StringProperty ratingProperty() {
        return rating;
    }

    public int getDuration() {
        return duration.get();
    }

    public IntegerProperty durationProperty() {
        return duration;
    }

    public double getPrice() {
        return price.get();
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    public String getActors() {
        return actors.get();
    }

    public StringProperty actorsProperty() {
        return actors;
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public String getCoverPath() {
        return coverPath.get();
    }

    public StringProperty coverPathProperty() {
        return coverPath;
    }

    public String getAgeLimit() {
        return ageLimit.get();
    }

    public StringProperty ageLimitProperty() {
        return ageLimit;
    }

    public String getGenre() {
        return genre.get();
    }

    public StringProperty genreProperty() {
        return genre;
    }


    // SETTERS

    public void setMovie_id(int movie_id) {
        this.movie_id = new SimpleIntegerProperty(movie_id);
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public void setRating(String rating) {
        this.rating = new SimpleStringProperty(rating);
    }

    public void setDuration(int duration) {
        this.duration = new SimpleIntegerProperty(duration);
    }

    public void setPrice(double price) {
        this.price = new SimpleDoubleProperty(price);
    }

    public void setActors(String actors) {
        this.actors = new SimpleStringProperty(actors);
    }

    public void setDescription(String description) {
        this.description = new SimpleStringProperty(description);
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = new SimpleStringProperty(coverPath);
    }

    public void setAgeLimit(String ageLimit) {
        this.ageLimit = new SimpleStringProperty(ageLimit);
    }

    public void setGenre(String genre) {
        this.genre = new SimpleStringProperty(genre);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + movie_id.getValue() +
                ", name=" + name.getValue() +
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

