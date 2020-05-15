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

        if(username.trim().isEmpty()||password.trim().isEmpty()||name.trim().isEmpty()||
        surname.trim().isEmpty()||email.trim().isEmpty()||phoneNumber.trim().isEmpty()){
            System.out.println("All fields are mandatory");

            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Registration Unsuccessful");
            alert.setContentText("All fields are mandatory. Please fill them in!");

            alert.showAndWait();
            return;
        }

        User user=new User(username, password, name, surname, email, phoneNumber, role);

        //check if unique
        ArrayList<User> ul=ReadWriteFile.readFile();
        if(!ul.contains(user)){
            ul.add(user);
            ReadWriteFile.writeFile(ul);
            System.out.println(user);;

            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Registration Successful");
            alert.setContentText("User "+username+" was added successfully");

            //empty fields
            usernameField.setText("");
            passwordField.setText("");
            namseField.setText("");
            surrnameField.setText("");
            emailField.setText("");
            phoneNumberField.setText("");
            farmerButton.setSelected(false);
            customerButton.setSelected(false);

            alert.showAndWait();
        }else{
            System.out.println("User already exists");

            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Registration Unsuccessful");
            alert.setContentText("Username already exits. Please try another one!");

            alert.showAndWait();
        }
    }
}
