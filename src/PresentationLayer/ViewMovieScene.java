package PresentationLayer;

import ApplicationLayer.DataTypes.Movie;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Tudor on 9/29/2016.
 */

/* TO DO:
    -> replace random path with movie.getCoverPath()
 */

public class ViewMovieScene {

    private Stage window;
    private Scene scene;
    private BorderPane root;
    private ImageView imageView;
    private Image image;
    private Label name, duration, price, actors,
            description, genre, rating, ageLimit;
    private TextField nameTF, durationTF, priceTF, actorsTF,
            descriptionTF, genreTF, ratingTF, ageLimitTF;

    public void setInfoScene(Movie movie){

        window = new Stage();

        // setting the labels and stuff
        image = new Image("file:D:\\School related\\SEM 3\\SWD\\KinoXP -Mand. Ass. 1\\board1.png",200,200,false,false);
        imageView = new ImageView(image);

        name = new Label("Name: "+movie.getName());
        duration = new Label("Duration: "+movie.getDuration()+" min");
        price = new Label("Price: "+movie.getPrice()+" kr");
        actors = new Label("Actors: "+movie.getActors());
        description = new Label("Description: "+movie.getDescription());
        genre = new Label("Genre: "+ movie.getGenre());
        rating = new Label("Rating: "+ movie.getRating()+" (IMDB)");
        ageLimit = new Label("Age limit: "+movie.getAgeLimit());

        VBox informationBox = new VBox(10,name,duration,price,actors,genre,rating,ageLimit);
        HBox imageAndInformation = new HBox(50,imageView,informationBox);
        VBox centerVBox = new VBox(20,imageAndInformation,description);

        Region leftReg = new Region();
        leftReg.setPrefWidth(50);
        Region topReg = new Region();
        topReg.setPrefHeight(50);

        root = new BorderPane();
        root.setCenter(centerVBox);
        root.setLeft(leftReg);
        root.setTop(topReg);

        // setting the scene and stage
        scene = new Scene(root, 500, 400);
        window.setScene(scene);
        window.show();
    }
}