package main.java.sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import main.Classes.Product;
import main.Classes.User;

public class AddProductController {
    @FXML private TextField titleField;
    @FXML private TextArea descriptionArea;
    @FXML private TextField stockField;
    @FXML private TextField priceField;
    @FXML private Button addButton;

    @FXML public void addProduct(){
        String title=titleField.getText();
        String description=descriptionArea.getText();
        int stock=1;
        try {
            stock=Integer.parseInt(stockField.getText());
        }catch (NumberFormatException e) {
            stock = 1;
        }
        double price=0;
        try {
            price=Double.parseDouble(stockField.getText());
        }catch (NumberFormatException e) {
            price = 0;
        }

        if(title.trim().isEmpty()||description.trim().isEmpty()){
            System.out.println("All fields are mandatory");

            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Add Product Unsuccessful");
            alert.setContentText("All fields are mandatory. Please fill them in!");

            alert.showAndWait();
            return;
        }

        Product newProduct=new Product(title,description,stock,price);
        User user=Main.getLoggedUser();
        if(!user.containsProduct(newProduct)){
            user.addProduct(newProduct);
            System.out.println("Added new product");

            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Successfull");
            alert.setContentText("Added product "+title+" successfully");

            //empty fields
            titleField.setText("");
            descriptionArea.setText("");
            stockField.setText("1");
            priceField.setText("0");

            alert.showAndWait();
        }else{
            System.out.println("Product already exists");

            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Unsuccessful");
            alert.setContentText("Product with this title already exits. Please try another one!");

            alert.showAndWait();
        }
    }

}
