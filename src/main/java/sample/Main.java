package main.java.sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.Classes.User;

import java.util.ArrayList;

public class Main extends Application {
    //Parent loginRoot=FXMLLoader.load(getClass().getResource("Login.fxml"));
    //Parent registerRoot=FXMLLoader.load(getClass().getResource("Register.fxml"));

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setTitle("Login - Online Market");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
