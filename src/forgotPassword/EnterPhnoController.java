
package forgotPassword;

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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class EnterPhnoController implements Initializable {

    @FXML
    private TextField userName;
    @FXML
    private TextField userPhoneNumber;
    @FXML
    private AnchorPane verifyPhonePage;
    @FXML
    private ImageView image;


    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    

    @FXML
    private void checkUser(ActionEvent event) throws IOException 
    {
        PassWordPojo pojo = new PassWordPojo();
        PassWordDAO dao = new PassWordDAO();
        pojo.setUserName(userName.getText());
        pojo.setUserPhno(Long.parseLong(userPhoneNumber.getText()));
        boolean userPhno = dao.checkUserNamePhno(pojo);
        if(userPhno == true)
        {
            Parent root = FXMLLoader.load(getClass().getResource("/newPassword/newPassWordPage.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setMaximized(true);
            stage.show();
            verifyPhonePage.getScene().getWindow().hide();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Failed");
            alert.setHeaderText("Enter Valid User Name And Phone Number");
            alert.showAndWait();
        }
    }

    @FXML
    private void backToLogin(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("/LoginPage/CustomerFXML.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
        verifyPhonePage.getScene().getWindow().hide();
    }
    
}
