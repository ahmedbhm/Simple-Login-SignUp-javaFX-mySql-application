package classes;

import javafx.scene.control.Alert;

/**
 *
 * @author bhm
 */
public class Utility {
    public static String username="";
    public static void succesMsg(String s){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(s);
        alert.showAndWait();
    }
    public static void ErrorMsg(String s){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning Dialog");
        alert.setHeaderText(null);
        alert.setContentText(s);
        alert.showAndWait();
    }

    }

