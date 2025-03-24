
package Crud;

import java.sql.*;
import user.InterfaceUser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

	public static user.Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}
}
