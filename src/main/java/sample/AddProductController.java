package sample;

import classes.Product;
import classes.ReadWriteFile;
import classes.User;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class AddProductController {
    @FXML private AnchorPane anchorPaneAddProduct;
    @FXML private TextField titleField;
    @FXML private TextArea descriptionArea;
    @FXML private TextField stockField;
    @FXML private TextField priceField;
    @FXML private Button addButton;
    @FXML private Button chooseImage;
    @FXML private ImageView imageView;
    private BufferedImage bufferedImage=null;
    private File fileSource;
    private File fileDestination;

    @FXML
    private void initialize(){
        anchorPaneAddProduct.getStylesheets().add("style.css");
    }

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
            price=Double.parseDouble(priceField.getText());
        }catch (NumberFormatException e) {
            price = 0;
        }

        if(title.trim().isEmpty()||description.trim().isEmpty()||bufferedImage==null){
            System.out.println("All fields are mandatory");

            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Add Product Unsuccessful");
            alert.setContentText("All fields are mandatory. Please fill them in!");

            alert.showAndWait();
            return;
        }
        ArrayList<User> ul= ReadWriteFile.readFile();
        Product newProduct=new Product(title,description,stock,price, fileDestination.getPath());
        User user= Main.getLoggedUser();
        int index=ul.indexOf(user);
        if(!ul.get(index).containsProduct(newProduct)){
            ul.get(index).addProduct(newProduct);
            saveImage();
            ReadWriteFile.writeFile(ul);
            System.out.println("Added new product");

            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Successfull");
            alert.setContentText("Added product "+title+" successfully");

            //empty fields
            titleField.setText("");
            descriptionArea.setText("");
            stockField.setText("1");
            priceField.setText("0");
            imageView.setImage(null);

            alert.showAndWait();
        }else{
            System.out.println("Product already exists");

            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Unsuccessful");
            alert.setContentText("Product with this title already exits. Please try another one!");

            alert.showAndWait();
        }
    }

    @FXML
    public void setImage(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        //Set extension filter
        FileChooser.ExtensionFilter extensionFilterJPG= new FileChooser.ExtensionFilter("JPG files (*.JPG)","*.JPG");
        FileChooser.ExtensionFilter extensionFilterJpg= new FileChooser.ExtensionFilter("jpg files (*.jpg)","*.jpg");
        FileChooser.ExtensionFilter extensionFilterPNG= new FileChooser.ExtensionFilter("PNG files (*.PNG)","*.PNG");
        FileChooser.ExtensionFilter extensionFilterPng= new FileChooser.ExtensionFilter("png files (*.png)","*.png");
        fileChooser.getExtensionFilters().addAll(extensionFilterJPG,extensionFilterJpg,extensionFilterPNG,extensionFilterPng);

        fileSource = fileChooser.showOpenDialog(null);
        fileDestination =new File("src/main/resources/"+ fileSource.getName());
        try {
            bufferedImage = ImageIO.read(fileSource);
            Image image= SwingFXUtils.toFXImage(bufferedImage, null);
            imageView.setImage(image);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveImage() {
        try {
            Files.copy(fileSource.toPath(),fileDestination.toPath());
            //ImageIO.write(bufferedImage, "jpg", fileSource);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
