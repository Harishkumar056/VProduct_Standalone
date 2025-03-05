
package newCustomer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mySqlConnection.ConnectionClass;

public class NewCustomerInsertDAO 
{
    public boolean checkOldUser(NewCustomerPojo po)
    {
        try 
        {
            Connection con = ConnectionClass.getMySqlConnection();
            PreparedStatement pre = con.prepareStatement("select customer_name,customer_phone from customer where customer_name = ? and customer_phone = ?");
            pre.setString(1, po.getUserName());
            pre.setLong(2, po.getUserPhoneNumber());
            ResultSet rs = pre.executeQuery();
            if(rs.next())
            {
                return true;
            }
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(NewCustomerInsertDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(NewCustomerInsertDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean insertCustomerDetails(NewCustomerPojo po)
    {
        try 
        {
            Connection con = ConnectionClass.getMySqlConnection();
            PreparedStatement pre = con.prepareStatement("insert into customer(customer_name,customer_phone,customer_password) values(?,?,?)");
            pre.setString(1, po.getUserName());
            pre.setLong(2, po.getUserPhoneNumber());
            pre.setString(3, po.getUserPassWord());
            
            if(pre.executeUpdate() > 0)
            {
                return true;
            }
            
        } 
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(NewCustomerInsertDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(NewCustomerInsertDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
