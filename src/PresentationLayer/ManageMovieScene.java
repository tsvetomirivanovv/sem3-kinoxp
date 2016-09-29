package PresentationLayer;

import ApplicationLayer.DataTypes.Movie;
import ApplicationLayer.ManageMovieController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/**
 * Created by Tsvetomir on 9/28/2016.
 */
public class ManageMovieScene {

    private Scene manageMovieScene;
    private BorderPane root;
    private Button addButton, removeButton, infoButton, editButton;
    public static TableView<Movie> moviesTableView;
    private TableColumn<Movie, Integer> movieIdColumn;
    private TableColumn<Movie, String> titleColumn;
    private TableColumn<Movie, Integer> durationColumn;
    private TableColumn<Movie, Double> priceColumn;
    private TableColumn<Movie, String> genreColumn;

    public Scene setManageMovieScene(){

        addButton = new Button("Add");
        addButton.setPrefSize(100,30);
        removeButton = new Button("Remove");
        removeButton.setPrefSize(100,30);
        infoButton = new Button("Info");
        infoButton.setPrefSize(100,30);
        editButton = new Button("Edit");
        editButton.setPrefSize(100,30);

        moviesTableView = new TableView<>();
        moviesTableView.setPrefHeight(435);
        //moviesTableView.itemsProperty().setValue(movieList);

        movieIdColumn = new TableColumn<>("Movie Id");
        movieIdColumn.setMinWidth(120);
        titleColumn = new TableColumn<>("Title");
        titleColumn.setMinWidth(120);
        durationColumn = new TableColumn<>("Duration");
        durationColumn.setMinWidth(120);
        priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(120);
        genreColumn = new TableColumn<>("Genre");
        genreColumn.setMinWidth(120);
        moviesTableView.getColumns().addAll(movieIdColumn,titleColumn,durationColumn,priceColumn,genreColumn);

        Region buttonReg = new Region();
        buttonReg.setPrefWidth(200);

        HBox buttonHBox = new HBox(20,buttonReg,addButton,removeButton,infoButton,editButton);

        VBox vBox = new VBox(30,moviesTableView,buttonHBox);

        root = new BorderPane();
        root.setCenter(vBox);

        manageMovieScene = new Scene(root, 700, 500);

        ManageMovieController manageMovieController = new ManageMovieController();
        addButton.setOnAction(event -> manageMovieController.handleAdd());

        return manageMovieScene;
    }
}
