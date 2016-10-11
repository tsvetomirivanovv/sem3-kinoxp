package ApplicationLayer;

import ApplicationLayer.DataTypes.Consumable;
import DataAccessLayer.DBConsumables;
import Kino.KinoXP;

public class AddConsSceneController {
    public void addConsumable(Consumable consumable) {
        // add the new movie to the global ObservableList and DB
        KinoXP.consumableList.add(consumable);
        DBConsumables dbConsumables = new DBConsumables();
        dbConsumables.insert(consumable);
    }

    public void editConsumable(Consumable consumable, String holdName) {
        int listIndex = KinoXP.consumableList.indexOf(consumable); //holds the index in the ObsArrayList

        KinoXP.consumableList.set(listIndex, consumable); //update the arraylist
        DBConsumables dbConsumables = new DBConsumables();
        dbConsumables.update(consumable);
    }
}
