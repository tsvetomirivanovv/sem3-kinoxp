package ApplicationLayer;

import Kino.KinoXP;
import PresentationLayer.ManageMovieScene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * Created by Tsvetomir on 9/28/2016.
 */
public class ManageMovieController {


    public static void removeMovie (Object o){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are your sure you want to delete this movie ?", ButtonType.CANCEL, ButtonType.YES);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.YES) {
            KinoXP.movieList.remove(o);
        }
    }

}