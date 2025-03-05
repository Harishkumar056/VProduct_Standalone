
package BuyScreen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mySqlConnection.ConnectionClass;

public class OrderDAO 
{
    public static boolean insertOrderDetailsDB(OrderedPojo po)
    {
        try 
        {
            Connection con = ConnectionClass.getMySqlConnection();
            PreparedStatement prep = con.prepareStatement("insert into ordered_details (customername,customerphone,customeraddress,cashmethod) values(?,?,?,?)");
            prep.setString(1, po.getCustomerName());
            prep.setLong(2, po.getCustomerPhno());
            prep.setString(3, po.getCustomerAddress());
            prep.setBoolean(4, po.isPaymentCod());
            if(prep.executeUpdate() > 0)
            {
                return true;
            }
            
        }
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
