package PresentationLayer;

import ApplicationLayer.DataTypes.Booking;
import ApplicationLayer.DataTypes.Consumable;
import Kino.KinoXP;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ViewConsumables {

    public static Double totalPrice = 0.0;
    public static TableView<Consumable> consumable_by_bookingTableView;
    public static ObservableList<Consumable> cons;
    BookingCustomerScene bookingCustomerScene = new BookingCustomerScene();
    private Label totalPriceLabel;
    private VBox rightVbox;
    private TextField quantityTextField;
    private Stage stage;
    private Scene scene;
    private BorderPane borderPane;
    private Button confirmButton, addConsumables, clearCart;
    private HBox hbox, tableHbox;
    private TableColumn<Consumable, Integer> idColumn;
    private TableColumn<Consumable, String> nameColumn;
    private TableColumn<Consumable, Double> priceColumn;

    public void setViewConsumablesScene(Booking booking, Double ticketTotalPrice, Label consumabel, Label ticketConsumabel) throws Exception {
        stage = new Stage();
        consumable_by_bookingTableView = new TableView<>();
        consumable_by_bookingTableView.itemsProperty().setValue(KinoXP.consumableList);


        quantityTextField = new TextField();
        quantityTextField.setPromptText("Quantity for consumable...");
        quantityTextField.setAlignment(Pos.CENTER_RIGHT);

        clearCart = new Button("Clear cart");
        addConsumables = new Button("Add to cart");
        confirmButton = new Button("Confirm");

        idColumn = new TableColumn<>("Consumable ID");
        idColumn.setPrefWidth(100);
        nameColumn = new TableColumn<>("Consumable name");
        nameColumn.setPrefWidth(100);
        priceColumn = new TableColumn<>("Consumable price");
        priceColumn.setPrefWidth(100);

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        consumable_by_bookingTableView.getColumns().addAll(idColumn, nameColumn, priceColumn);

        consumable_by_bookingTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        consumable_by_bookingTableView.setPrefHeight(435);


        totalPriceLabel = new Label("Total price: " + totalPrice);
        totalPriceLabel.setAlignment(Pos.CENTER);

        rightVbox = new VBox();
        rightVbox.setPrefWidth(200);
        rightVbox.setAlignment(Pos.TOP_RIGHT);
        rightVbox.getChildren().addAll(totalPriceLabel);


        hbox = new HBox(5);
        hbox.setAlignment(Pos.BOTTOM_CENTER);
        hbox.getChildren().addAll(quantityTextField, clearCart, addConsumables, confirmButton);

        addConsumables.setOnAction(event -> {
            String selectedConsName = consumable_by_bookingTableView.getSelectionModel().getSelectedItem().getName();
            int selectedConsQuantity = Integer.parseInt(quantityTextField.getText());
            double consumableTotalPrice = selectedConsQuantity * consumable_by_bookingTableView.getSelectionModel().getSelectedItem().getPrice();

            Consumable consumable = new Consumable(selectedConsQuantity, selectedConsName, consumableTotalPrice);


            Label l = new Label(consumable.getId() + " x : " + consumable.getName() + " = " + consumable.getPrice());

            rightVbox.getChildren().add(l);
            quantityTextField.clear();
            totalPrice += consumableTotalPrice;
            totalPriceLabel.setText("Total price: " + totalPrice);
        });

        clearCart.setOnAction(event -> {
            rightVbox.getChildren().clear();
            totalPrice = 0.0;
            totalPriceLabel.setText("Total price: " + totalPrice);
            rightVbox.getChildren().add(totalPriceLabel);
        });

        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.runLater(() -> {
                    consumabel.setText("Total Price for Consumables: " + totalPrice);
                    ticketConsumabel.setText("Total Price for movie tickets + consumables: " + String.valueOf(totalPrice + ticketTotalPrice));
                    stage.close();
                });
            }
        });

        borderPane = new BorderPane();
        borderPane.setPadding(new Insets(30));
        borderPane.setCenter(consumable_by_bookingTableView);
        borderPane.setBottom(hbox);
        borderPane.setRight(rightVbox);

        scene = new Scene(borderPane, 700, 500);
        scene.getStylesheets().add("CSS");
        stage.setScene(scene);
        stage.show();
    }


}

