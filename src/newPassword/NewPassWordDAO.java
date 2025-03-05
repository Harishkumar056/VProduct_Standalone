
package newPassword;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mySqlConnection.ConnectionClass;

public class NewPassWordDAO 
{
    public boolean setNewPassWord(NewPassWordPojo pojo) throws SQLException
    {
         
        try 
        {
            Connection con = ConnectionClass.getMySqlConnection();
            PreparedStatement pre = con.prepareStatement("update customer set customer_password = ? where customer_name = ?");
            pre.setString(1, pojo.getUserPassWord());
            pre.setString(2, pojo.getUserName());
            if(pre.executeUpdate() > 0)
            {
                return true;
            }
        } 
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(NewPassWordDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
