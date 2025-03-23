
package loginapp;

import java.sql.*;
import javax.swing.JOptionPane;

public class DbConnection {
    Connection connection = null;
    
    public static Connection connectionDB(){
        try{
            Class.forName("org.sqlite.JDBC");
            Connection connection  = DriverManager.getConnection("jdbc:sqlite:loginSqlite.db");
            //JOptionPane.showMessageDialog(null, "Connection Succeded!!!");
            return connection;
        }catch(Exception e){
            //JOptionPane.showMessageDialog(null, "Connection Failed!!! " +e);
            return null;
        }
    }
}
