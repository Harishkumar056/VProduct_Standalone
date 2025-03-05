
package newCustomer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class NewCustomerFXMLController implements Initializable {

    @FXML
    private TextField newUserName;
    @FXML
    private TextField newUserPhno;
    @FXML
    private PasswordField newUserPass;
    @FXML
    private Button createAccount;
    @FXML
    private AnchorPane newUserScreen;
    @FXML
    private Button backToLogin;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    

    @FXML
    private void createAccountButton(ActionEvent event) throws IOException 
    {
        NewCustomerPojo pojo = new NewCustomerPojo();
        NewCustomerInsertDAO dao = new NewCustomerInsertDAO();
        pojo.setUserName(newUserName.getText());
        pojo.setUserPhoneNumber(Long.parseLong(newUserPhno.getText()));
        pojo.setUserPassWord(newUserPass.getText());
        
        boolean existUser = dao.checkOldUser(pojo);
        if(existUser != true)
        {
            boolean res = dao.insertCustomerDetails(pojo);
            if(res == true)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("SUCCESS");
                alert.setHeaderText("Customer Data Inserted");
                alert.showAndWait();
                Stage stage = new Stage();
                Parent root1 = FXMLLoader.load(getClass().getResource("/LoginPage/CustomerFXML.fxml"));
                Scene scene = new Scene(root1);
                stage.setScene(scene);
                stage.setMaximized(true);
                stage.show();
                newUserScreen.getScene().getWindow().hide();
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("FAILED");
                alert.setHeaderText("Customer Data Insertion Failed");
                alert.showAndWait();
                Stage stage = new Stage();
                Parent root1 = FXMLLoader.load(getClass().getResource("/LoginPage/CustomerFXML.fxml"));
                Scene scene = new Scene(root1);
                stage.setScene(scene);
                stage.setMaximized(true);
                stage.show();
                newUserScreen.getScene().getWindow().hide();
            }
        }
        else
        {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("FAILED");
                alert.setHeaderText("This user is already logined");
                alert.showAndWait();
                Stage stage = new Stage();
                Parent root1 = FXMLLoader.load(getClass().getResource("/LoginPage/CustomerFXML.fxml"));
                Scene scene = new Scene(root1);
                stage.setScene(scene);
                stage.setMaximized(true);
                stage.show();
                newUserScreen.getScene().getWindow().hide();
        }
    }

    @FXML
    private void backLoginButtton(ActionEvent event) throws IOException 
    {
        Stage stage = new Stage();
        Parent root1 = FXMLLoader.load(getClass().getResource("/LoginPage/CustomerFXML.fxml"));
        Scene scene = new Scene(root1);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
        newUserScreen.getScene().getWindow().hide();
    }
    
}
