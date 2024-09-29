package application;

import java.sql.Connection;
import java.sql.DriverManager;

public class MainDatabase{
    public static Connection connectDB()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load the driver
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/account", "root", "connect@123");
            return connection;
        }
        catch(Exception e){e.printStackTrace();}
        return null;
        
    }
    
}
