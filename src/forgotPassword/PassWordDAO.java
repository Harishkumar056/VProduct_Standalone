
package forgotPassword;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mySqlConnection.ConnectionClass;

public class PassWordDAO 
{
    public boolean checkUserNamePhno(PassWordPojo pojo)
    {
        try 
        {
            Connection con = ConnectionClass.getMySqlConnection();
            PreparedStatement pre = con.prepareStatement("select * from customer where customer_name = ? AND customer_phone = ?");
            pre.setString(1,pojo.getUserName());
            pre.setLong(2, pojo.getUserPhno());
            ResultSet rs = pre.executeQuery();
            if(rs.next())
            {
                return true;
            }
        }
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(PassWordDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(PassWordDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
