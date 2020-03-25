/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginapp;

import classes.Database;
import classes.Utility;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author ahmed
 */
public class LoginController  {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button btn;
    @FXML
    private void Login(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
        String username=this.username.getText();
        String password=this.password.getText();
        if(password.equals("") || username.equals("")){
            Utility.ErrorMsg("Individual error : empty form fields !");
        }else{
            btn.setDisable(true);
            String[] user={username,password};
            
            Database db =new Database();
            
            if(db.clientExist(username)>0){
                if(db.passwordVirify(username,password)) 
                    goHome(event,username);
                else  
                    Utility.ErrorMsg("mot pass incorrect !");
            }else{
                Utility.ErrorMsg("ce compte n'existe pas !");
            }
            btn.setDisable(false);
        }
    }
    private void goHome(ActionEvent event,String username) throws IOException{
        Utility.username=username;
        newWindow("Home.fxml",event);
    }
    @FXML
    private void signUP(ActionEvent event) throws IOException{
        newWindow("SignUp.fxml",event);
    }
    private void newWindow(String dist,ActionEvent event) throws IOException{
        FXMLLoader loader=new FXMLLoader(getClass().getResource(dist));
        Parent root = (Parent) loader.load();

        Stage stage=new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
    }  

    
}
