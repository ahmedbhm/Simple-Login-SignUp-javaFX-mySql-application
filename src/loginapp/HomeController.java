package loginapp;

import classes.Utility;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
public class HomeController {
    @FXML
    Label username;
    @FXML
    public void initialize() throws ClassNotFoundException {
        username.setText(Utility.username);
    }


}
