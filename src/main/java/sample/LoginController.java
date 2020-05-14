package main.java.sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import main.Classes.ReadWriteFile;
import main.Classes.User;
import main.Classes.UserRole;

import java.util.ArrayList;

public class LoginController {
    @FXML
    private Button loginButton;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField textField;
    @FXML
    private Hyperlink hyperlink;
    @FXML
    private void loginButtonClicked(){
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
}
