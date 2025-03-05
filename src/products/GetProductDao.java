
package products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mySqlConnection.ConnectionClass;

public class GetProductDao 
{  
    public List<GetProductPojo> getProductDB()
    {
        try 
        {
            Connection con = ConnectionClass.getMySqlConnection();
            PreparedStatement pre = con.prepareStatement("select * from add_product");
            ResultSet rs = pre.executeQuery();
            
            List<GetProductPojo> li = new ArrayList();
            while(rs.next())
            {
                GetProductPojo po = new GetProductPojo();
                po.setProductName(rs.getString("product_name"));
                po.setProductBrand(rs.getString("product_brand"));
                po.setProductSize(rs.getString("product_size"));
                po.setProductPrice(rs.getDouble("product_price"));
                po.setProductImage(rs.getBytes("product_image"));
                
                li.add(po);
            }
            return li;
        }
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(GetProductDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(GetProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
