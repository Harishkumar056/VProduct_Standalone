
package newPassword;

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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class NewPassWordPageController implements Initializable 
{
    @FXML
    private AnchorPane newPasswordPage;
    @FXML
    private TextField userName;
    @FXML
    private PasswordField newPassword;


    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    

    @FXML
    private void newPassword(ActionEvent event) 
    {
        NewPassWordPojo pojo = new NewPassWordPojo();
        NewPassWordDAO dao = new NewPassWordDAO();
        pojo.setUserName(userName.getText());
        pojo.setUserPassWord(newPassword.getText());
        try
        {
            boolean setPassWord = dao.setNewPassWord(pojo);
            if(setPassWord == true)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("SUCCESSFULY CHANGED");
                alert.setHeaderText("Your New PassWord Entered Sucessfully");
                alert.showAndWait();
                Stage stage = new Stage();
                //This for move next Screen
                Parent root1 = FXMLLoader.load(getClass().getResource("/LoginPage/CustomerFXML.fxml"));
                Scene scene = new Scene(root1);
                stage.setScene(scene);
                stage.setMaximized(true);
                stage.show();
                newPasswordPage.getScene().getWindow().hide();
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("FAILED");
                alert.setHeaderText("Your NewPassWord Not Sucessfully Entered !!!!");
                alert.showAndWait();
                Stage stage = new Stage();
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(NewPassWordPageController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex)
        {
            Logger.getLogger(NewPassWordPageController.class.getName()).log(Level.SEVERE, null, ex);
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
        newPasswordPage.getScene().getWindow().hide();
    }
}
