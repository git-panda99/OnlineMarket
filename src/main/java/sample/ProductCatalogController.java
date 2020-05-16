package main.java.sample;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import main.Classes.Product;
import main.Classes.ReadWriteFile;
import main.Classes.User;

import java.util.ArrayList;

public class ProductCatalogController {

    @FXML
    private VBox vBox;


    public void initialize(){
        ArrayList<User> ul= ReadWriteFile.readFile();
        for(User u:ul)
            for(Product p:u.getProductList()) {

            }

    }

}
