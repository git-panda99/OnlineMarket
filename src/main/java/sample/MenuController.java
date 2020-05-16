package sample;

import classes.UserRole;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MenuController {
    @FXML
    private AnchorPane menuAnchorPane;
    @FXML
    private Label helloLabel;
    @FXML
    private Hyperlink productCatalogHyperlink;
    @FXML
    private Hyperlink myOrdersHyperlink;
    @FXML
    private Hyperlink addProductsHyperlink;
    @FXML
    private Hyperlink usersHyperlink;
    @FXML
    private Hyperlink logoutHyperlink;

    public void initialize(){
        //menuAnchorPane.setStyle("-fx-background-image: url('/../resources/rasberryBread.jpg')");
        menuAnchorPane.getStylesheets().add("style.css");
        //hello
        helloLabel.setText("Howdy, "+Main.getLoggedUser().getName()+" "+Main.getLoggedUser().getSurname()+"!");
        //Product Catalog

        //My Orders

        //Add Product
        if(Main.getLoggedUser().getRole()== UserRole.CUSTOMER){
            addProductsHyperlink.setText("");
        }
        //Users
        if(Main.getLoggedUser().getRole()==UserRole.CUSTOMER||Main.getLoggedUser().getRole()==UserRole.FARMER){
            usersHyperlink.setText("");
        }
    }

    @FXML
    private void productCatalogHyperlinkClicked(ActionEvent event)throws Exception {
        Parent registerParent = FXMLLoader.load(getClass().getResource("ProductCatalog.fxml"));
        Scene registerScene=new Scene(registerParent);

        Stage primaryStage= (Stage) ((Node)event.getSource()).getScene().getWindow();

        primaryStage.setScene(registerScene);
        primaryStage.show();
    }

    @FXML
    private void myOrdersHyperlinkClicked(ActionEvent event)throws Exception {
        Parent registerParent = FXMLLoader.load(getClass().getResource("MyOrders.fxml"));
        Scene registerScene=new Scene(registerParent);

        Stage primaryStage= (Stage) ((Node)event.getSource()).getScene().getWindow();

        primaryStage.setScene(registerScene);
        primaryStage.show();
    }

    @FXML
    private void addProductHyperlinkClicked(ActionEvent event)throws Exception {
        Parent registerParent = FXMLLoader.load(getClass().getResource("AddProduct.fxml"));
        Scene registerScene=new Scene(registerParent);

        Stage primaryStage= (Stage) ((Node)event.getSource()).getScene().getWindow();

        primaryStage.setScene(registerScene);
        primaryStage.show();
    }

    @FXML
    private void usersHyperlinkClicked(ActionEvent event)throws Exception {
        Parent registerParent = FXMLLoader.load(getClass().getResource("Users.fxml"));
        Scene registerScene=new Scene(registerParent);

        Stage primaryStage= (Stage) ((Node)event.getSource()).getScene().getWindow();

        primaryStage.setScene(registerScene);
        primaryStage.show();
    }

    @FXML
    private void logoutHyperlinkClicked(ActionEvent event)throws Exception {
        Parent registerParent = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene registerScene=new Scene(registerParent);

        Stage primaryStage= (Stage) ((Node)event.getSource()).getScene().getWindow();

        primaryStage.setScene(registerScene);
        primaryStage.show();
    }

}
