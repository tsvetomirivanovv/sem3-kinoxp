package PresentationLayer;

import ApplicationLayer.DataTypes.Consumable;
import ApplicationLayer.ManageConsumablesController;
import Kino.KinoXP;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ManageConsumablesScene {
    //fields
    public static TableView<Consumable> consumablesTableView;
    private Scene manageConsumablesScene;
    private BorderPane root;
    private Button addButton, editButton, backButton;
    private TableColumn<Consumable, String> nameColumn;
    private TableColumn<Consumable, Double> priceColumn;

    //initialize the scene
    public Scene setManageConsumablesScene() {

        addButton = new Button("Add");
        addButton.setPrefSize(70, 30);
        editButton = new Button("Edit");
        editButton.setPrefSize(70, 30);
        backButton = new Button("Back");
        backButton.setPrefSize(70, 30);

        consumablesTableView = new TableView<>();
        consumablesTableView.setPrefHeight(435);
        consumablesTableView.setPadding(new Insets(30, 30, 0, 30));
        consumablesTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        consumablesTableView.itemsProperty().setValue(KinoXP.consumableList);

        nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(120);
        priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(120);

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        consumablesTableView.getColumns().addAll(nameColumn, priceColumn);

        HBox buttonHBox = new HBox(20, addButton, editButton, backButton);
        buttonHBox.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(30, consumablesTableView, buttonHBox);
        vBox.setAlignment(Pos.TOP_CENTER);

        root = new BorderPane();
        root.setCenter(vBox);

        manageConsumablesScene = new Scene(root, 670, 530);
        manageConsumablesScene.getStylesheets().add("CSS");

        // make an instantiation of the Controller
        ManageConsumablesController manageConsumablesController = new ManageConsumablesController();

        // make functionality for the buttons
        addButton.setOnAction(e -> manageConsumablesController.addConsumable());
        editButton.setOnAction(event -> manageConsumablesController.editConsumable(consumablesTableView.getSelectionModel().getSelectedItem()));
        backButton.setOnAction(e -> manageConsumablesController.backToHomeScene());

        return manageConsumablesScene;
    }
}
