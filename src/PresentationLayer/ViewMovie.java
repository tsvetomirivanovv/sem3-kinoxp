package PresentationLayer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 * Created by Tudor on 9/29/2016.
 */
public class ViewMovie extends Application {
    private Label movieName, duration, price, actors, description, genre, rating, ageLimit;
    private ImageView imageView;
    private Image image;
    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane pane = new StackPane();
        image = new Image("file:C:\\Users\\Tudor\\Downloads\\grand.jpg",200,200,false,false);
        imageView = new ImageView(image);
        movieName = new Label();
        movieName.setText("movie name");
        duration = new Label();
        duration.setText("duration");
        price = new Label();
        price.setText("price");
        actors = new Label();
        actors.setText("actors");
        description = new Label();
        description.setText("description");
        genre = new Label();
        genre.setText("genre");
        rating = new Label();
        rating.setText("rating");
        ageLimit = new Label();
        ageLimit.setText("age limit");
        VBox informationBox = new VBox();
        informationBox.getChildren().add(rating);
        informationBox.getChildren().add(description);
        informationBox.getChildren().add(genre);
        informationBox.getChildren().add(duration);
        informationBox.getChildren().add(price);
        informationBox.getChildren().add(ageLimit);
        HBox imageAndInformation = new HBox();
        imageAndInformation.getChildren().add(imageView);
        imageAndInformation.getChildren().add(informationBox);
        VBox mainBox = new VBox();
        mainBox.getChildren().add(movieName);
        mainBox.getChildren().add(imageAndInformation);
        pane.getChildren().add(mainBox);
        primaryStage.setScene(new Scene(pane, 600, 400));
        primaryStage.show();
    }
}