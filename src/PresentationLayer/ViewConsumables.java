package PresentationLayer;

import ApplicationLayer.DataTypes.Booking;
import ApplicationLayer.DataTypes.Consumable;
import Kino.KinoXP;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import javafx.stage.Stage;




public class ViewConsumables {

    private Stage stage;
    private Scene scene;
    private BorderPane borderPane;
    private Button confirmButton;
    private HBox hbox;
    public static TableView<Consumable> consumable_by_bookingTableView;
    private TableColumn<Consumable, Integer> idColumn;
    private TableColumn<Consumable, String> nameColumn;
    private TableColumn<Consumable, Double> priceColumn;

    public void setViewConsumablesScene(Booking booking) throws Exception {
        stage = new Stage();
        consumable_by_bookingTableView = new TableView<>();
        consumable_by_bookingTableView.itemsProperty().setValue(KinoXP.consumableList);

        confirmButton = new Button("Confirm");

        idColumn = new TableColumn<>("Consumable ID");
        idColumn.setMinWidth(120);
        nameColumn = new TableColumn<>("Consumable name");
        nameColumn.setMinWidth(120);
        priceColumn = new TableColumn<>("Consumable price");
        priceColumn.setMinWidth(120);

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        consumable_by_bookingTableView.getColumns().addAll(idColumn, nameColumn, priceColumn);

        consumable_by_bookingTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        consumable_by_bookingTableView.setPrefHeight(435);
        consumable_by_bookingTableView.setPadding(new Insets(30, 30, 0, 30));

        hbox = new HBox(5);
        hbox.setAlignment(Pos.BOTTOM_RIGHT);
        hbox.getChildren().addAll(confirmButton);

        borderPane = new BorderPane();
        borderPane.setCenter(consumable_by_bookingTableView);
        borderPane.setBottom(hbox);

        scene = new Scene(borderPane, 500, 400);
        stage.setScene(scene);
        stage.show();
    }


}

