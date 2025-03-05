/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerDetails;

/**
 *
 * @author 91934
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mySqlConnection.ConnectionClass;

public class CustomerDetailsDAO 
{
    public List<CustomerDetailPojo> getAllCustomerDetails()
    {
        try 
        {
            List<CustomerDetailPojo> al = new ArrayList();
            Connection con = ConnectionClass.getMySqlConnection();
            PreparedStatement prep = con.prepareStatement("select * from customer");
            ResultSet rs = prep.executeQuery();
            while(rs.next())
            {
                CustomerDetailPojo pojo = new CustomerDetailPojo();
                
                pojo.setSerialNumber(rs.getInt("s_num"));
                pojo.setCustomerName(rs.getString("customer_name"));
                pojo.setCustomerPassword(rs.getString("customer_password"));
                pojo.setCustomerPhoneNumber(rs.getLong("customer_phone"));
                al.add(pojo);
            }
            return al;
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(CustomerDetailsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(CustomerDetailsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
