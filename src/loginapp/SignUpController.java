/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginapp;

import classes.Database;
import classes.Utility;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class SignUpController {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField password1;
    @FXML
    private Button btn;
    @FXML
    private void SignUp(ActionEvent event) throws  ClassNotFoundException, SQLException, IOException {
        String username=this.username.getText();
        String password=this.password.getText();
        String password1=this.password1.getText();
        
        btn.setDisable(true);
        if(password.equals("") || username.equals("") ||password1.equals("")){
            Utility.ErrorMsg("Individual error : empty form fields !");
        }else{
            if(password.equals(password1)){
                Database db1 =new Database();
                if(db1.clientExist(username)>0){
                     Utility.ErrorMsg("username déja existe ");
                }else {
                     db1.AddClient(username,password);
                     goHome(event,username);
                }
            }else{
                Utility.ErrorMsg("les mots pass pas identiques !");
            }
        }
        btn.setDisable(false);
    }
    private void goHome(ActionEvent event,String username) throws IOException{
        Utility.username=username;
        newWindow("Home.fxml",event);
        
    }
    @FXML
    private void Login(ActionEvent event) throws IOException {
        newWindow("Login.fxml",event);
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
