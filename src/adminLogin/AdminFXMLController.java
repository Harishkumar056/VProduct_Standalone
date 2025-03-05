
package adminLogin;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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


public class AdminFXMLController implements Initializable {

    @FXML
    private TextField adminName;
    @FXML
    private PasswordField adminPassword;
    @FXML
    private Button adminLogin;
    @FXML
    private AnchorPane adminPage;
    @FXML
    private Button adminBackid;


    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }      

    @FXML
    private void adminLoginButton(ActionEvent event) throws ClassNotFoundException, SQLException, IOException 
    {
        AdminPassPojo pojo = new AdminPassPojo();
        AdminPassDao dao = new AdminPassDao();
        
        pojo.setAdminName(adminName.getText());
        pojo.setAdminPassWord(adminPassword.getText());
        
        boolean adminRes = dao.checkAdmin(pojo);
        
        if(adminRes == true)
        {
            Stage stage = new Stage();
            Parent root1 = FXMLLoader.load(getClass().getResource("/adminOption/adOption.fxml"));
            Scene scene = new Scene(root1);
            stage.setScene(scene);
            stage.setMaximized(true);
            stage.show();
            adminPage.getScene().getWindow().hide();
        }
        else
        {   
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("error!!!");
            alert.setHeaderText("Enter Valid userName and Password");
            alert.showAndWait();
        }    
    }

    @FXML
    private void adminBackButton(ActionEvent event) throws IOException 
    {
        Parent root = FXMLLoader.load(getClass().getResource("/garmentproject/FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
        adminPage.getScene().getWindow().hide();
    }
}
