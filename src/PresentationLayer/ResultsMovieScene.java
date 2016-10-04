package PresentationLayer;

import ApplicationLayer.DataTypes.Movie;
import ApplicationLayer.ManageMovieController;
import ApplicationLayer.ResultsMovieController;
import Kino.KinoXP;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.time.LocalDate;

/**
 * Created by Tsvetomir on 9/28/2016.
 */
public class ResultsMovieScene {

    public static TableView<Movie> moviesTableView;
    private Scene manageMovieScene;
    private BorderPane root;
    private Button addButton, removeButton, infoButton, editButton;
    private TableColumn<Movie, String> nameColumn;
    private TableColumn<Movie, Integer> durationColumn;
    private TableColumn<Movie, Double> priceColumn;
    private TableColumn<Movie, String> genreColumn;
    ResultsMovieController resultsMovieController = new ResultsMovieController();

    public Scene setResultsMovieScene(LocalDate date) {

        addButton = new Button("Adfdsfgdsd");
        addButton.setPrefSize(100, 30);
        removeButton = new Button("Remove");
        removeButton.setPrefSize(100, 30);
        infoButton = new Button("Info");
        infoButton.setPrefSize(100, 30);
        editButton = new Button("Edit");
        editButton.setPrefSize(100, 30);

        moviesTableView = new TableView<>();
        moviesTableView.setPrefHeight(435);
        // TO DO: Create function in the ctrl to sort the movies just for the date passed as parameter
        // resultsMovieController.searchMoviesByDate();
        moviesTableView.itemsProperty().setValue(KinoXP.movieList);

        nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(120);
        durationColumn = new TableColumn<>("Duration");
        durationColumn.setMinWidth(120);
        priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(120);
        genreColumn = new TableColumn<>("Genre");
        genreColumn.setMinWidth(120);

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));
        moviesTableView.getColumns().addAll(nameColumn, durationColumn, priceColumn, genreColumn);

        Region buttonReg = new Region();
        buttonReg.setPrefWidth(200);

        HBox buttonHBox = new HBox(20, buttonReg, addButton, removeButton, infoButton, editButton);

        VBox vBox = new VBox(30, moviesTableView, buttonHBox);

        root = new BorderPane();
        root.setCenter(vBox);

        manageMovieScene = new Scene(root, 700, 500);

        // make an instantiation of the Controller
        ManageMovieController manageMovieController = new ManageMovieController();

        // make functionality for the buttons
        addButton.setOnAction(e -> manageMovieController.addMovie());
        infoButton.setOnAction(e -> manageMovieController.showInfoScene(moviesTableView.getSelectionModel().getSelectedItem()));
        removeButton.setOnAction(e -> manageMovieController.removeMovie(moviesTableView.getSelectionModel().getSelectedItem()));
        editButton.setOnAction(event -> manageMovieController.editMovie(moviesTableView.getSelectionModel().getSelectedItem()));

        return manageMovieScene;
    }
}
