
package RemoveProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mySqlConnection.ConnectionClass;

public class RemoveDAO 
{
    public List<RemovePojo> removeProductDB()
    {
        List<RemovePojo> li = new ArrayList();
        try
        {
            Connection con = ConnectionClass.getMySqlConnection();
            PreparedStatement pre = con.prepareStatement("select * from add_product");
            ResultSet rs = pre.executeQuery();
            
            while(rs.next())
            {
                RemovePojo pojo = new RemovePojo();
                
                pojo.setProductName(rs.getString("product_name"));
                pojo.setProductId(rs.getInt("product_id"));
                pojo.setProductBrand(rs.getString("product_brand"));
                pojo.setProductSize(rs.getString("product_size"));
                pojo.setProductPrice(rs.getDouble("product_price"));
                pojo.setProductImage(rs.getBytes("product_image"));
                
                li.add(pojo);
            }
            return li;
        } 
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(RemoveDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(RemoveDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return li;
    }
    
    public boolean deleteProduct(RemovePojo pojo) throws SQLException
    {
        try
        {
            Connection con = ConnectionClass.getMySqlConnection();
            PreparedStatement prep = con.prepareStatement("delete from add_product where product_id = ?");
            prep.setInt(1, pojo.getProductId());
            if(prep.executeUpdate() > 0)
            {
                return true;
            }
            
        } 
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(RemoveDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
