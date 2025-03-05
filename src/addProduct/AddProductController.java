
package addProduct;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class AddProductController implements Initializable {

    @FXML
    private AnchorPane addProductPage;
   
    @FXML
    private TextField productName;
    
    @FXML
    private TextField productPrice;

    @FXML
    private TextField productSIze;

    @FXML
    private TextField productId;
    @FXML
    private ImageView uploadImg;
    @FXML
    private TextField productBrand;

    private File selectedFile;
    @FXML
    private ImageView bgimage;

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
    }    

    @FXML
    private void BackToAdminLogin(ActionEvent event) throws IOException 
    {
        Stage stage = new Stage();
        Parent root1 = FXMLLoader.load(getClass().getResource("/adminOption/adOption.fxml"));
        Scene scene = new Scene(root1);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
        addProductPage.getScene().getWindow().hide();
    }

    @FXML//Insert all details in DataBase
    private void uploadImage(ActionEvent event) 
    {
        try
        {
            AddProductPojo pojo = new AddProductPojo();
            addProductDao dao = new addProductDao();

            pojo.setProductName(productName.getText());
            pojo.setProductId(Integer.parseInt(productId.getText()));
            pojo.setProductBrand(productBrand.getText());
            pojo.setProductSize(productSIze.getText());
            pojo.setProductPrice(Double.parseDouble(productPrice.getText()));

            FileInputStream fis = new FileInputStream(selectedFile);
            byte[] imageData = new byte[(int) selectedFile.length()];
            fis.read(imageData);
            fis.close();

            if(imageData != null)
            {
                pojo.setProductImage(imageData);
                boolean res = dao.insertNewProduct(pojo);
                if(res == true)
                {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Sucessfully");
                    alert.setHeaderText("Product Added Sucessfully");
                    alert.showAndWait();
                }
                else
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Failed");
                    alert.setHeaderText("Image should have 60 kb");
                    alert.showAndWait();
                }
            }    
            getClear();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
            showErrorAlert("File not found", "Please select a valid image file.");
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
            showErrorAlert("Error", "Error reading the image file.");
        }
    }

    @FXML
    private void browseImage(ActionEvent event) 
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose an Image");
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );
        
        Stage stage = (Stage) addProductPage.getScene().getWindow(); // Get the current stage
        selectedFile = fileChooser.showOpenDialog(stage);
        
        if(selectedFile != null) 
        {
            Image image = new Image(selectedFile.toURI().toString());
            uploadImg.setImage(image);
        }
    }

    @FXML
    private void searchProduct(ActionEvent event) 
    {
        addProductDao dao = new addProductDao();
        int checkProdctID = dao.checkProduct(productName.getText());
        if(checkProdctID != 0)
        {
            productId.setText(Integer.toString(checkProdctID));
        }
    }  
    
    private void showErrorAlert(String title, String message) 
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(message);
        alert.showAndWait();
    }
    
    private void getClear()
    {
        productName.clear();
        productPrice.clear();
        productSIze.clear();
        productBrand.clear();
        productId.clear();
        uploadImg.setImage(null);
    }
}
