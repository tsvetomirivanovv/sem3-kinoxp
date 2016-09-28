package ApplicationLayer;

import Kino.KinoXP;
import PresentationLayer.ManageMovieScene;

/**
 * Created by Andrei on 28/09/2016.
 */
public class HomeSceneController {

    private ManageMovieScene manageMovieScene = new ManageMovieScene();

    public void changeToManageMovieScene(){
        KinoXP.window.setScene(manageMovieScene.setManageMovieScene());
    }
}
