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
    private void registerButtonClicked(){
        String usernamse;
        String password;
        String name;
        String surname;
        String email;
        String phoneNumber;
        UserRole role;
        if(farmerButton.isSelected())
            role=UserRole.FARMER;
        else
            role=UserRole.CUSTOMER;
    }
}
