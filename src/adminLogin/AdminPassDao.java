
package adminLogin;

import mySqlConnection.ConnectionClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class AdminPassDao 
{
    public boolean checkAdmin(AdminPassPojo po) throws ClassNotFoundException, SQLException
    {
        Connection con = ConnectionClass.getMySqlConnection();
        PreparedStatement pre = con.prepareStatement("select * from garment_admin where name = ? and password =?");
        pre.setString(1, po.getAdminName());
        pre.setString(2, po.getAdminPassWord());
        ResultSet rs = pre.executeQuery();
        
        if(rs.next())
        {
            return true;
        }
        return false;
    }
}
