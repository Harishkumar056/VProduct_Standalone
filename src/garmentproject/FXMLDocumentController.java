
package garmentproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {
    
    
    @FXML
    private Label welcomeLab;
    @FXML
    private Button customerId;
    @FXML
    private Button adminId;
    @FXML
    private AnchorPane welcomePage;
    //FXMLDocumentController control = new FXMLDocumentController();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    //customer Button action 
    @FXML
    private void customerButt(ActionEvent event) throws IOException 
    {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/products/productPage.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        stage.setMaximized(true);
        welcomePage.getScene().getWindow().hide(); 
        //control.screenClose();
    }
    //admin button action
    @FXML
    private void adminButt(ActionEvent event) throws IOException 
    {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/adminLogin/AdminFXML.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        stage.setMaximized(true);
        welcomePage.getScene().getWindow().hide();
        //control.screenClose();
    }
    
//    private void screenClose()
//    {
//        welcomePage.getScene().getWindow().hide();
//    }
}
