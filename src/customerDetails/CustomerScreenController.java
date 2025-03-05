
package customerDetails;

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


public class CustomerScreenController implements Initializable 
{
    @FXML
    private TableView<CustomerDetailPojo> customerDetailsTab;
    @FXML
    private TableColumn<CustomerDetailPojo, Integer> serialNum;
    @FXML
    private TableColumn<CustomerDetailPojo, String> customerName;
    @FXML
    private TableColumn<CustomerDetailPojo, String> customerPassword;
    @FXML
    private TableColumn<CustomerDetailPojo, Long> customerPhone;
    @FXML
    private AnchorPane customerPage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        CustomerDetailsDAO dao = new CustomerDetailsDAO();
        List<CustomerDetailPojo> lis =dao.getAllCustomerDetails();
        
        for(CustomerDetailPojo pojo : lis)
        {
            customerDetailsTab.getItems().add(pojo);
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
            customerPage.getScene().getWindow().hide();
        }
        catch (IOException ex)
        {
            Logger.getLogger(CustomerScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
