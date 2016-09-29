package PresentationLayer;

import ApplicationLayer.DataTypes.Movie;
import ApplicationLayer.ManageMovieController;
import Kino.KinoXP;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.util.Map;

/**
 * Created by Tsvetomir on 9/28/2016.
 */
public class ManageMovieScene {

    private Scene manageMovieScene;
    private BorderPane root;
    private Button addButton, removeButton, infoButton, editButton;
    /*public static TableView<Object> moviesTableView;
    private TableColumn<Object, String> titleColumn;
    private TableColumn<Object, Integer> durationColumn;
    private TableColumn<Object, Double> priceColumn;
    private TableColumn<Object, String> genreColumn;*/
    public static TableView<Movie> moviesTableView;
    private TableColumn<Movie, Integer> movieIdColumn;
    private TableColumn<Movie, String> titleColumn;
    private TableColumn<Movie, Integer> durationColumn;
    private TableColumn<Movie, Double> priceColumn;
    private TableColumn<Movie, String> genreColumn;




    public Scene setManageMovieScene(){
        ObservableList<Movie> movies = FXCollections.observableArrayList(KinoXP.movieList);

        movies.add(new Movie("Jason Bourne",95,250,"Matt Damon","Cool description","123","19","Action","4.5"));
        movies.add(new Movie("Jason Bourne",95,250,"Matt Damon","Cool description","123","19","Action","4.5"));

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

        titleColumn = new TableColumn<>("Title");
        titleColumn.setMinWidth(120);
        durationColumn = new TableColumn<>("Duration");
        durationColumn.setMinWidth(120);
        priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(120);
        genreColumn = new TableColumn<>("Genre");
        genreColumn.setMinWidth(120);

        /*titleColumn.setCellValueFactory(new PropertyValueFactory<Object, String>("name"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<Object, Integer>("duration"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Object, Double>("price"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<Object, String>("genre"));
        moviesTableView.getColumns().addAll(titleColumn,durationColumn,priceColumn,genreColumn);
        moviesTableView.itemsProperty().setValue(KinoXP.movieList);*/
        Region buttonReg = new Region();
        buttonReg.setPrefWidth(200);

        HBox buttonHBox = new HBox(20,buttonReg,addButton,removeButton,infoButton,editButton);

        VBox vBox = new VBox(30,moviesTableView,buttonHBox);

        root = new BorderPane();
        root.setCenter(vBox);

        manageMovieScene = new Scene(root, 700, 500);

       /* removeButton.setOnAction(event -> {
            ManageMovieController.removeMovie(moviesTableView.getSelectionModel().getSelectedItem());

        });*/

        ManageMovieController manageMovieController = new ManageMovieController();
        addButton.setOnAction(event -> manageMovieController.handleAdd());

        return manageMovieScene;



    }

}
