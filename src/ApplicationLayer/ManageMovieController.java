package ApplicationLayer;

import Kino.KinoXP;
import PresentationLayer.AddButtonScene;

/**
 * Created by Tsvetomir on 9/28/2016.
 */
public class ManageMovieController {

    public void handleAdd() {
        AddButtonScene addButtonScene = new AddButtonScene();
        KinoXP.window.setScene(addButtonScene.setAddScene());
    }
}
