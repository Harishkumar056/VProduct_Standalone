  
package BuyScreen;

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
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class BuyScreenController implements Initializable 
{
    @FXML
    private AnchorPane BuyScreen;
    @FXML
    private TextField customerName;
    @FXML
    private TextField customerPhno;
    @FXML
    private TextField customerAdress;
    @FXML
    private RadioButton okCod;
    @FXML
    private RadioButton noCod;
    @FXML
    private ImageView buyBGImg;


    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    

    
    @FXML
    private void orderProceed(ActionEvent event) 
    {
        if(okCod.isSelected())
        {
            try 
            {
                OrderedPojo pojo = new OrderedPojo();
                
                pojo.setCustomerName(customerName.getText());
                pojo.setCustomerPhno(Long.parseLong(customerPhno.getText()));
                pojo.setCustomerAddress(customerAdress.getText());
                pojo.setPaymentCod(true);
                
                boolean dataDB = OrderDAO.insertOrderDetailsDB(pojo);
                
                if(dataDB == true)
                {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Order Sucess");
                    alert.setHeaderText("Your OrderPlaced within 1 day delivery Expected");
                    alert.showAndWait();
                }
                    
                Stage stage = new Stage();
                Parent root1 = FXMLLoader.load(getClass().getResource("/products/productPage.fxml"));
                Scene scene = new Scene(root1);
                stage.setScene(scene);
                stage.setMaximized(true);
                stage.show();
                BuyScreen.getScene().getWindow().hide();
                
            } catch (IOException ex) 
            {
                Logger.getLogger(BuyScreenController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(noCod.isSelected())
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Failed");
            alert.setHeaderText("We Will improve online Payment GateWay Transacation");
            alert.showAndWait();
        }
    }
    

    @FXML
    private void codOk(ActionEvent event)
    {
        noCod.setSelected(false);
    }

    @FXML
    private void codNo(ActionEvent event) 
    {
        okCod.setSelected(false);
    }

    @FXML
    private void backToMain(ActionEvent event) 
    {
        try
        {
            Stage stage = new Stage();
            Parent root1 = FXMLLoader.load(getClass().getResource("/products/productPage.fxml"));
            Scene scene = new Scene(root1);
            stage.setScene(scene);
            stage.setMaximized(true);
            stage.show();
            BuyScreen.getScene().getWindow().hide();
        } 
        catch (IOException ex) 
            {
            Logger.getLogger(BuyScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
