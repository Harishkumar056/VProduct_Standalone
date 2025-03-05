
package addProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mySqlConnection.ConnectionClass;

public class addProductDao 
{
    public int checkProduct(String product_name)
    {
        try 
        {
            System.out.println(product_name);
            Connection con = ConnectionClass.getMySqlConnection();
            PreparedStatement pre = con.prepareStatement("select product_id from add_product where product_name = ?");
            pre.setString(1, product_name);
            ResultSet rs = pre.executeQuery();
            
            if(rs.next())
            {
                System.out.println(rs.getInt(2));
                return rs.getInt(2);
            }
        }
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(addProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(addProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public boolean insertNewProduct(AddProductPojo po) 
    {
        try 
        {
            Connection con = ConnectionClass.getMySqlConnection();
            PreparedStatement pre = con.prepareStatement("insert into add_product(product_name,product_id,product_brand,product_size,product_price,product_image) values(?,?,?,?,?,?)");
            pre.setString(1, po.getProductName());
            pre.setInt(2, po.getProductId());
            pre.setString(3, po.getProductBrand());
            pre.setString(4, po.getProductSize());
            pre.setDouble(5, po.getProductPrice());
            pre.setBytes(6, po.getProductImage());
            
            if(pre.executeUpdate() > 0)
            {
                return true;
            }
            
        } 
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(addProductDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(addProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
