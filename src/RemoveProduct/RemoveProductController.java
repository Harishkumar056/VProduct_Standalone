
package RemoveProduct;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import products.GetProductDao;
import products.GetProductPojo;


public class RemoveProductController implements Initializable 
{
    @FXML
    private AnchorPane removeProductPage;
    @FXML
    private GridPane gridRemoveProduct;
    @FXML
    private ImageView removeImage;
    @FXML
    private Label productId;
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
            Logger.getLogger(RemoveProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    private void showImage() throws FileNotFoundException, IOException 
    {
        RemoveDAO dao = new RemoveDAO();
        List<RemovePojo> list = dao.removeProductDB();

        gridRemoveProduct.getChildren().clear(); // Clear old data
        int col = 0, row = 0; // Grid position
        
        for(RemovePojo po : list)
        {
            byte[] imageData = po.getProductImage();
            System.out.println(imageData);
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
                    productImage.setFitWidth(300);
                    productImage.setFitHeight(300);
                    productImage.setImage(image);  // Set the image here

                    // Labels
                    Label nameLabel = new Label(po.getProductName());
                    Label priceLabel = new Label("₹" + po.getProductPrice());
                    Label brandLabel = new Label(po.getProductBrand());

                    nameLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
                    priceLabel.setStyle("-fx-text-fill: green; -fx-font-size: 12px;");
                    brandLabel.setStyle("-fx-text-fill: gray; -fx-font-size: 12px;");

                    productBox.getChildren().addAll(productImage, nameLabel, priceLabel, brandLabel);

                    // **SET CLICK EVENT FOR EACH PRODUCT**
                    productBox.setOnMouseClicked(event -> {
                        updateSelectedProduct(po);
                    });

                    // Add VBox to GridPane
                    gridRemoveProduct.add(productBox, col, row);

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
                System.out.println("No image data found for product: " + po.getProductName());
            }
        }
        
    }

    private void updateSelectedProduct(RemovePojo pojo) 
    {
        if (pojo.getProductImage() == null || pojo.getProductImage().length == 0) 
        {
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
            removeImage.setImage(image);
            removeImage.setFitWidth(200);
            removeImage.setFitHeight(200);
            removeImage.setPreserveRatio(true);

            // Update Labels
            productName.setText(pojo.getProductName());
            productBrand.setText(pojo.getProductBrand());
            productPrice.setText("₹" + pojo.getProductPrice());
            productId.setText(String.valueOf(pojo.getProductId()));
            
            //for delete Current Image(product)
            
        });
    }

    @FXML
    private void DeleteProduct(ActionEvent event) 
    {
        try 
        {
            RemovePojo pojo = new RemovePojo();
            RemoveDAO dao = new RemoveDAO();
            
            pojo.setProductId(Integer.parseInt(productId.getText()));
            boolean delete = dao.deleteProduct(pojo);
            if(delete == true)
            {
                setAlertMessage("Sucess","Sucessfully Deleted Product");
            }
            else
            {
                setAlertMessage("Failed","Delete Failed !!!");
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(RemoveProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
    }
    
    private void setAlertMessage(String title,String Header)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(Header);
        alert.showAndWait();
    }

    @FXML
    private void backToAdminOption(ActionEvent event) 
    { 
        try
        {
            Parent root1 = FXMLLoader.load(getClass().getResource("/adminOption/adOption.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root1);
            stage.setScene(scene);
            stage.setMaximized(true);
            stage.show();
            removeProductPage.getScene().getWindow().hide();
        } 
        catch (IOException ex)
        {
            Logger.getLogger(RemoveProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
