
package LoginPage;

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


public class CustomerFXMLController implements Initializable 
{

    @FXML
    private TextField userName;
    @FXML
    private PasswordField userPassword;
    @FXML
    private Button userLogin;
    @FXML
    private Button newUser;
    @FXML
    private AnchorPane cutomerLoginPage;
    @FXML
    private Button backToFirstScreen;
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
    }    

    @FXML
    private void loginButton(ActionEvent event) throws IOException 
    {
        LoginPojo pojo = new LoginPojo();
        LoginDAO dao = new LoginDAO();
        
        pojo.setUserName(userName.getText());
        pojo.setUserPassword(userPassword.getText());
        boolean loginRes = dao.checkCustomer(pojo);
        if(loginRes == true)
        {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/BuyScreen/BuyScreen.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            stage.setMaximized(true);
            cutomerLoginPage.getScene().getWindow().hide();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Login Failed");
            alert.setHeaderText("Enter Valid User Name and User PassWord");
            alert.showAndWait();
        }
    }

    @FXML
    private void newUserButton(ActionEvent event) throws IOException 
    {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/newCustomer/NewCustomerFXML.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
        //set id for page(scene) this for close the screen syntax
        cutomerLoginPage.getScene().getWindow().hide();
    }

    @FXML
    private void backScreen(ActionEvent event) throws IOException 
    {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/garmentproject/FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setMaximized(true);
        cutomerLoginPage.getScene().getWindow().hide();
    }

    @FXML
    private void forgotPassword(ActionEvent event) throws IOException 
    {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/forgotPassword/enterPhno.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setMaximized(true);
        cutomerLoginPage.getScene().getWindow().hide();
    }
    
    
}
