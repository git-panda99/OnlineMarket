package sample;

import classes.ReadWriteFile;
import classes.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class LoginController {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button loginButton;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField textField;
    @FXML
    private Hyperlink hyperlink;
    @FXML
    private void initialize(){
        anchorPane.getStylesheets().add("style.css");
    }
    @FXML
    private void loginButtonClicked(ActionEvent event)throws Exception{
        String user= textField.getText();
        String password= passwordField.getText();
        /*ArrayList<User> userArrayList=new ArrayList<User>();
        try{
            userArrayList.add(new User("admin", "admin", "The", "Administrator", "", "", UserRole.ADMIN));
        }catch(Exception e){
            System.out.println("Role exception");
        }*/

        ArrayList<User> userArrayList=ReadWriteFile.readFile();
        boolean found=false;
        for(User i: userArrayList){
            if(i.validCredentials(user, password)){
                System.out.println("Login successfull");
                found=true;
                Main.setLoggedUser(i);
                loginSuccessfulRedirect(event);
                break;
            }
        }
        if(!found){
            System.out.println("Login unsuccessfull");

            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Unsuccessful");
            alert.setContentText("The username, password or both are incorrect. Please try again!");

            alert.showAndWait();

            //reset textfield and password field
            textField.setText("");
            passwordField.setText("");
        }
    }

    @FXML
    private void registerHyperlinkClicked(ActionEvent event)throws Exception {
        Parent registerParent = FXMLLoader.load(getClass().getResource("Register.fxml"));
        Scene registerScene=new Scene(registerParent);

        Stage primaryStage= (Stage) ((Node)event.getSource()).getScene().getWindow();

        primaryStage.setScene(registerScene);
        primaryStage.show();
    }

    private void loginSuccessfulRedirect(ActionEvent event)throws Exception {
        Parent registerParent = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene registerScene=new Scene(registerParent);

        Stage primaryStage= (Stage) ((Node)event.getSource()).getScene().getWindow();

        primaryStage.setScene(registerScene);
        primaryStage.show();
    }
}
