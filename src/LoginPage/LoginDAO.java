
package LoginPage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mySqlConnection.ConnectionClass;

public class LoginDAO 
{
    public boolean checkCustomer(LoginPojo po)
    {
        try 
        {
            Connection conc = ConnectionClass.getMySqlConnection();
            PreparedStatement pre =conc.prepareStatement("select customer_name,customer_password from customer where customer_name = ? AND customer_password = ? ");
            pre.setString(1, po.getUserName());
            pre.setString(2, po.getUserPassword());
            ResultSet rs = pre.executeQuery();
            if(rs.next())
            {
                return true;
            }
            
        }
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
