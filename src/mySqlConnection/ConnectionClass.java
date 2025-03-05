
package mySqlConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionClass 
{
    public static Connection getMySqlConnection() throws ClassNotFoundException 
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url ="jdbc:mysql://localhost:3306/garment";
            String userName = "Harish Kumar";
            String password = "#Harishkumar1";
            Connection con = DriverManager.getConnection(url, userName, password);
            return con;
        }
        catch(SQLException checkSqlCone)
        {
            checkSqlCone.printStackTrace();
        }
        return null;
    }
}
