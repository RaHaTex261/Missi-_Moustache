
package Crud;

import java.sql.*;

public class DbConnection {
    Connection connection = null;
    
    public static Connection connectionDB(){
        try{
            Class.forName("org.sqlite.JDBC");
            Connection connection  = DriverManager.getConnection("jdbc:sqlite:loginSqlite.db");
            return connection;
        }catch(Exception e){
            return null;
        }
    }
}
