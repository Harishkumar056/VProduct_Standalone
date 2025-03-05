
package orderCustomer;

import BuyScreen.OrderedPojo;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class OrderDetailsController implements Initializable 
{

    @FXML
    private AnchorPane orderDataScreem;
    @FXML
    private TableView<OrderedPojo> orderTable;
    @FXML
    private TableColumn<OrderedPojo, String> customerName;
    @FXML
    private TableColumn<OrderedPojo, String> customerAddress;
    @FXML
    private TableColumn<OrderedPojo, Long> customerPhone;
    @FXML
    private TableColumn<OrderedPojo, Boolean> cashCod;
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        List<OrderedPojo> list = OrderedDAO.getCustomerDetails();
        
        for(OrderedPojo pojo : list)
        {
            orderTable.getItems().add(pojo);
        }
    }    

    @FXML
    private void backToAdminOption(ActionEvent event) 
    {
        try 
        {
            Stage stage = new Stage();
            Parent root1 = FXMLLoader.load(getClass().getResource("/adminOption/adOption.fxml"));
            Scene scene = new Scene(root1);
            stage.setScene(scene);
            stage.setMaximized(true);
            stage.show();
            orderDataScreem.getScene().getWindow().hide();
        } 
        catch (IOException ex)
        {
            Logger.getLogger(OrderDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
