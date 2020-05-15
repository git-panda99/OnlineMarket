package main.java.sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import main.Classes.ReadWriteFile;
import main.Classes.User;
import main.Classes.UserRole;

import java.util.ArrayList;

public class RegisterController {
    @FXML
    private Button registerButton;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField namseField;
    @FXML
    private TextField surrnameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private RadioButton customerButton;
    @FXML
    private RadioButton farmerButton;
    @FXML
    private ToggleGroup toggleGroup;

    @FXML
    private void registerButtonClicked(){
        String username=usernameField.getText();
        String password=passwordField.getText();
        String name=namseField.getText();
        String surname=surrnameField.getText();
        String email=emailField.getText();
        String phoneNumber=phoneNumberField.getText();
        UserRole role;
        if(farmerButton.isSelected())
            role=UserRole.FARMER;
        else
            role=UserRole.CUSTOMER;

        User user=new User(username, password, name, surname, email, phoneNumber, role);

        ArrayList<User> ul=ReadWriteFile.readFile();
        ul.add(user);

        ReadWriteFile.writeFile(ul);

        System.out.println(user);;
    }
}
