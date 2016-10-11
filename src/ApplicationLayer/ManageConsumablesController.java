package ApplicationLayer;

import ApplicationLayer.DataTypes.Consumable;
import Kino.KinoXP;
import PresentationLayer.AddConsButtonScene;
import PresentationLayer.HomeScene;
import javafx.scene.control.Alert;

public class ManageConsumablesController {

    //buttons actions
    public void backToHomeScene() {
        // go back to the HomeScene
        HomeScene homeScene = new HomeScene();
        KinoXP.window.setScene(homeScene.setHomeScene());
    }

    public void addConsumable() {
        //shows the AddButtonScene with blank fields
        AddConsButtonScene addConsButtonScene = new AddConsButtonScene();
        Consumable consumable = new Consumable();
        addConsButtonScene.setAddScene(consumable, "add");
    }

    public void editConsumable(Consumable consumable) {
        try {//shows the AddButtonScene with populated fields
            AddConsButtonScene addConsButtonScene = new AddConsButtonScene();
            addConsButtonScene.setAddScene(consumable, "edit");
        } catch (NullPointerException nullPointer) {
            showAlert();
        }
    }

    public void showAlert() { //no consumable selected
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("No consumable selected!");
        alert.setContentText("Please select a consumable.");
        alert.showAndWait();
    }
}
