
package adminOption;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class AdOptionController implements Initializable 
{
    @FXML
    private ImageView adminOptionBG;
    @FXML
    private AnchorPane adminOptionScreen;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addProduct(ActionEvent event) 
    {
        try 
        {
            Stage stage = new Stage();
            Parent root1 = FXMLLoader.load(getClass().getResource("/addProduct/addProduct.fxml"));
            Scene scene = new Scene(root1);
            stage.setScene(scene);
            stage.setMaximized(true);
            stage.show();
       // adminOptionPage.getScene().getWindow().hide();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(AdOptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        adminOptionScreen.getScene().getWindow().hide();
    }

    @FXML
    private void removeProduct(ActionEvent event) 
    {
        try 
        {
            Stage stage = new Stage();
            Parent root1 = FXMLLoader.load(getClass().getResource("/RemoveProduct/RemoveProduct.fxml"));
            Scene scene = new Scene(root1);
            stage.setScene(scene);
            stage.setMaximized(true);
            stage.show();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(AdOptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        adminOptionScreen.getScene().getWindow().hide();
    }

    @FXML
    private void backToAdminLogin(ActionEvent event) 
    {
        try 
        {
            Stage stage = new Stage();
            Parent root1 = FXMLLoader.load(getClass().getResource("/adminLogin/AdminFXML.fxml"));
            Scene scene = new Scene(root1);
            stage.setScene(scene);
            stage.setMaximized(true);
            stage.show();
        }
        catch (IOException ex) 
        {
            Logger.getLogger(AdOptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        adminOptionScreen.getScene().getWindow().hide();
    }

    @FXML
    private void customerDetails(ActionEvent event) 
    {
        try 
        {
            Stage stage = new Stage();
            Parent root1 = FXMLLoader.load(getClass().getResource("/customerDetails/customerScreen.fxml"));
            Scene scene = new Scene(root1);
            stage.setScene(scene);
            stage.setMaximized(true);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AdOptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        adminOptionScreen.getScene().getWindow().hide();
    }

    @FXML
    private void orderDetails(ActionEvent event) 
    {
        try 
        {
            Stage stage = new Stage();
            Parent root1 = FXMLLoader.load(getClass().getResource("/orderCustomer/orderDetails.fxml"));
            Scene scene = new Scene(root1);
            stage.setScene(scene);
            stage.setMaximized(true);
            stage.show();
            adminOptionScreen.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(AdOptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }       

    @FXML
    private void viewProducts(ActionEvent event)
    {
        try 
        {
            Stage stage = new Stage();
            Parent root1 = FXMLLoader.load(getClass().getResource("/products/productPage.fxml"));
            Scene scene = new Scene(root1);
            stage.setScene(scene);
            stage.setMaximized(true);
            stage.show();
            adminOptionScreen.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(AdOptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
