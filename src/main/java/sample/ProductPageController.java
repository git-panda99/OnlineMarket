package sample;

import classes.Product;
import classes.ReadWriteFile;
import classes.User;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ProductPageController {
    @FXML
    private AnchorPane anchorPaneProductPage;
    @FXML
    private HBox detailImageHBox =new HBox();


    public void initialize(){
        anchorPaneProductPage.getStylesheets().add("style.css");
        /*productInProductPage=new Product(ProductCatalogController.getProductInProductPage().getTitle(),
                ProductCatalogController.getProductInProductPage().getDescription(),
                ProductCatalogController.getProductInProductPage().getStock(),
                ProductCatalogController.getProductInProductPage().getPrice(),
                ProductCatalogController.getProductInProductPage().getImage());

         */
        Product productInProductPage = ProductCatalogController.getProductInProductPage();
        String farmerProductInProductPage = ProductCatalogController.getFarmerProductInProductPage() + "";
        if(productInProductPage!=null) {
            //details
            VBox productVBox = new VBox();
            productVBox.setStyle("-fx-padding: 20 10 20 20");
            Label titleLabel = new Label(productInProductPage.getTitle());
            titleLabel.setFont(new Font("Arial", 30));
            titleLabel.setStyle("-fx-text-alignment: left; -fx-font-weight: bold; -fx-padding: 10 0 10 0");
            Label priceLabel = new Label(productInProductPage.getPrice() + " EUR/kg");
            priceLabel.setFont(new Font("Arial", 18));
            Label stockLabel = new Label("in Stock: " + productInProductPage.getStock());
            stockLabel.setStyle("-fx-padding: 4 2 2 5");
            HBox priceStockHBox = new HBox(priceLabel, stockLabel);
            priceStockHBox.setStyle("-fx-padding: 0 0 10 0");
            Label quantityLabel = new Label("Choose quantity: ");
            quantityLabel.setFont(new Font("Arial", 14));
            TextField quantityField =new TextField("1");
            HBox chooseQuantityHBox = new HBox(quantityLabel, quantityField);
            Button orderButton = new Button("Order");
            orderButton.setOnAction(new EventHandler<>() {
                @Override
                public void handle(ActionEvent event) {
                    ArrayList<User> ul = ReadWriteFile.readFile();
                    for (User u : ul)
                        if (u.getUsername().equals(farmerProductInProductPage))
                            for (Product p : u.getProductList())
                                if (p.getTitle().equals(productInProductPage.getTitle())) {
                                    int q=Integer.parseInt( quantityField.getText());
                                    if(p.order(q)) {
                                        stockLabel.setText("in Stock: " + productInProductPage.getStock());
                                        System.out.println("Stock -1");

                                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                        alert.setTitle("Order Successful");
                                        alert.setContentText("You ordered product " + p.getTitle() + " successfully");
                                        alert.showAndWait();
                                        ReadWriteFile.writeFile(ul);
                                        detailImageHBox.getChildren().clear();
                                        productInProductPage.setStock(p.getStock());
                                        initialize();
                                    }else{
                                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                        alert.setTitle("Order Unsuccessful");
                                        alert.setContentText("Not enough stock");
                                        alert.showAndWait();
                                    }
                                }
                }
            });
            Label descriptionArea= new Label("Product Description: "+productInProductPage.getDescription());
            productVBox.getChildren().addAll(titleLabel, priceStockHBox, chooseQuantityHBox, orderButton,descriptionArea);
            //Image
            ImageView imageView = new ImageView();
            try {
                BufferedImage bufferedImage = ImageIO.read(new File(productInProductPage.getImage()));
                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                imageView.setImage(image);

            } catch (IOException e) {
                e.printStackTrace();
            }
            imageView.setFitHeight(200);
            imageView.setFitWidth(200);
            //imageView.setStyle("-fx-padding: 0 20 0 20");
            detailImageHBox.getChildren().addAll(imageView, productVBox);
            detailImageHBox.setStyle("-fx-padding: 0 50 0 50");
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


}
