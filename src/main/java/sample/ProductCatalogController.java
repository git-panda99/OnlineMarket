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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ProductCatalogController {
    @FXML
    private AnchorPane anchorPaneProductCatalog;

    @FXML
    private GridPane gridPane;
    private static Product productInProductPage;
    private static String farmerProductInProductPage;
  
    public void initialize(){
        anchorPaneProductCatalog.getStylesheets().add("style.css");
        ArrayList<User> ul= ReadWriteFile.readFile();
        int i=0,j=0;
        gridPane.setHgap(200);
        gridPane.setVgap(100);
        for(User u:ul) {

            for (Product p : u.getProductList()) {
                HBox detailImageHBox =new HBox();
                //details
                VBox productVBox = new VBox();
                productVBox.setStyle("-fx-padding: 20 10 20 20");
                Label titleLabel = new Label(p.getTitle());
                titleLabel.setFont(new Font("Arial", 24));
                Label priceLabel = new Label(p.getPrice() + " EUR/kg");
                priceLabel.setFont(new Font("Arial",18));
                Label stockLabel = new Label("in Stock: "+p.getStock());
                stockLabel.setStyle("-fx-padding: 4 2 2 5");
                HBox priceStockHBox=new HBox(priceLabel,stockLabel);
                Button seeMoreButton = new Button("See More");
                seeMoreButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        Parent registerParent;
                        try {
                            productInProductPage=p;
                            farmerProductInProductPage=u.getUsername();
                            registerParent = FXMLLoader.load(getClass().getResource("ProductPage.fxml"));
                            assert registerParent != null;
                            Scene registerScene=new Scene(registerParent);
                            Stage primaryStage= (Stage) ((Node)event.getSource()).getScene().getWindow();
                            primaryStage.setScene(registerScene);
                            primaryStage.show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                productVBox.getChildren().addAll(titleLabel, priceStockHBox, seeMoreButton);
                //Image
                ImageView imageView=new ImageView();
                try {
                    BufferedImage bufferedImage = ImageIO.read(new File(p.getImage()));
                    Image image= SwingFXUtils.toFXImage(bufferedImage, null);
                    imageView.setImage(image);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                imageView.setFitHeight(100);
                imageView.setFitWidth(100);
                detailImageHBox.getChildren().addAll(imageView,productVBox);
                detailImageHBox.setStyle("-fx-padding: 0 50 0 50");
                gridPane.add(detailImageHBox, i, j, 2, 2);
                i++;
                if(i==2){
                    i=0;
                    j++;
                }
            }
        }
    }

    public static Product getProductInProductPage() {
        return productInProductPage;
    }

    public static String getFarmerProductInProductPage() {
        return farmerProductInProductPage;
    }

    @FXML
    private void menuHyperlinkClicked(ActionEvent event)throws Exception {
        Parent registerParent = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene registerScene=new Scene(registerParent);

        Stage primaryStage= (Stage) ((Node)event.getSource()).getScene().getWindow();

        primaryStage.setScene(registerScene);
        primaryStage.show();
    }
}
