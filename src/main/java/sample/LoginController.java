package main.java.sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
        ArrayList<User> userArrayList=new ArrayList<User>();
        try{
            userArrayList.add(new User("admin", "admin", "The", "Administrator", "", "", UserRole.ADMIN));
        }catch(Exception e){
            System.out.println("Role exception");
        }

        ReadWriteFile.writeFile(userArrayList);

        System.out.println(userArrayList+" Button clicked!");
    }
}
