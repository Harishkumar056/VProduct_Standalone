
package orderCustomer;

import BuyScreen.OrderedPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mySqlConnection.ConnectionClass;

public class OrderedDAO 
{
    public static List<OrderedPojo> getCustomerDetails()
    {
        try
        {
            List<OrderedPojo> list = new ArrayList();
            Connection con = ConnectionClass.getMySqlConnection();
            PreparedStatement pre = con.prepareStatement("select * from ordered_details");
            ResultSet rs = pre.executeQuery();
            
            while(rs.next())
            {
                OrderedPojo po = new OrderedPojo();
                
                po.setCustomerName(rs.getString("customername"));
                po.setCustomerAddress(rs.getString("customeraddress"));
                po.setCustomerPhno(rs.getLong("customerphone"));
                po.setPaymentCod(true);
                list.add(po);
            }
            return list;
        } 
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(OrderedDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OrderedDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
