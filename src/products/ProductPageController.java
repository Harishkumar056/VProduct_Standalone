
package products;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProductPageController implements Initializable {

    @FXML
    private AnchorPane productPage;
    @FXML
    private GridPane grid;
    @FXML
    private ImageView ShowImage;
    @FXML
    private Label productName;
    @FXML
    private Label productBrand;
    @FXML
    private Label productPrice;
    

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        try 
        {
            showImage();
        }
        catch (IOException ex) 
        {
            Logger.getLogger(ProductPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    private void showImage() throws FileNotFoundException, IOException 
    {
        GetProductDao dao = new GetProductDao();
        List<GetProductPojo> li = dao.getProductDB();

        grid.getChildren().clear(); // Clear old data
        int col = 0, row = 0; // Grid position

        for (GetProductPojo pojo : li)
        {
            byte[] imageData = pojo.getProductImage();

            if (imageData != null && imageData.length > 0) 
            {
                ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
                Image image = new Image(bis, 150, 150, true, true);

                //if (!image.isError()) 
                //{  
                    VBox productBox = new VBox(10);
                    productBox.setAlignment(Pos.CENTER);
                    productBox.setStyle("-fx-border-color: black; -fx-padding: 10px; -fx-background-color: #f9f9f9; -fx-border-radius: 10px;");

                    // Add Image
                    ImageView productImage = new ImageView();
                    productImage.setFitWidth(250);
                    productImage.setFitHeight(250);
                    productImage.setImage(image);  // Set the image here

                    // Labels
                    Label nameLabel = new Label(pojo.getProductName());
                    Label priceLabel = new Label("₹" + pojo.getProductPrice());
                    Label brandLabel = new Label(pojo.getProductBrand());

                    nameLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
                    priceLabel.setStyle("-fx-text-fill: green; -fx-font-size: 12px;");
                    brandLabel.setStyle("-fx-text-fill: gray; -fx-font-size: 12px;");

                    productBox.getChildren().addAll(productImage, nameLabel, priceLabel, brandLabel);

                    // **SET CLICK EVENT FOR EACH PRODUCT**
                    productBox.setOnMouseClicked(event -> {
                        updateSelectedProduct(pojo);
                    });

                    // Add VBox to GridPane
                    grid.add(productBox, col, row);

                    col++;
                    if (col == 3) { // 3 items per row
                        col = 0;
                        row++;
                    }
    //            } 
    //            else 
    //            {
    //                System.out.println("Invalid image data: " + image.getException());
    //            }
            } 
            else {
                System.out.println("No image data found for product: " + pojo.getProductName());
            }
        }
    }

   private void updateSelectedProduct(GetProductPojo pojo) {
    if (pojo.getProductImage() == null || pojo.getProductImage().length == 0) {
        System.out.println("Image data is NULL for product: " + pojo.getProductName());
        return;
    }

    ByteArrayInputStream bis = new ByteArrayInputStream(pojo.getProductImage());
    Image image = new Image(bis);

    if (image.isError()) {
        System.out.println("Error loading image: " + image.getException());
        return;
    }

    Platform.runLater(() -> {
        ShowImage.setImage(image);
        ShowImage.setFitWidth(300);
        ShowImage.setFitHeight(300);
        ShowImage.setPreserveRatio(true);

        // Update Labels
        productName.setText(pojo.getProductName());
        productBrand.setText(pojo.getProductBrand());
        productPrice.setText("₹" + pojo.getProductPrice());
       
    });
}



    @FXML
    private void buyBttuon(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("/LoginPage/CustomerFXML.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
        productPage.getScene().getWindow().hide();
    }

    @FXML
    private void backToLogin(ActionEvent event) 
    {
        
        try 
        {
            Parent root = FXMLLoader.load(getClass().getResource("/garmentproject/FXMLDocument.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setMaximized(true);
            stage.show();
            productPage.getScene().getWindow().hide();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(ProductPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
