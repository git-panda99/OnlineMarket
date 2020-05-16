package main.java.sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import main.Classes.Product;
import main.Classes.ReadWriteFile;
import main.Classes.User;

import java.util.ArrayList;

public class ProductCatalogController {

    @FXML
    private GridPane gridPane;

    /*public ProductCatalogController(){
        initialize();
    }*/


    public void initialize(){
        ArrayList<User> ul= ReadWriteFile.readFile();
        int i=0,j=0;
        gridPane.setHgap(200);
        gridPane.setVgap(100);
        for(User u:ul) {

            for (Product p : u.getProductList()) {
                VBox productVBox = new VBox();
                productVBox.setStyle("-fx-padding: 20 50 20 50");
                Label titleLabel = new Label(p.getTitle());
                titleLabel.setFont(new Font("Arial", 24));
                Label priceLabel = new Label(p.getPrice() + " EUR/kg");
                priceLabel.setFont(new Font("Arial",18));
                Label stockLabel = new Label("in Stock: "+p.getStock());
                stockLabel.setStyle("-fx-padding: 4 2 2 5");
                HBox priceStockHBox=new HBox(priceLabel,stockLabel);
                Button seeMoreButton = new Button("See More");
                productVBox.getChildren().addAll(titleLabel, priceStockHBox, seeMoreButton);
                gridPane.add(productVBox, i, j, 2, 2);
                i++;
                if(i==2){
                    i=0;
                    j++;
                }
            }
        }
    }

}
