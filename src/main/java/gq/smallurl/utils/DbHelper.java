package gq.smallurl.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author  Robin Raju
 * @since Sept 14, 2015
 *
 * Helper class to connect to MySQL Database
 * */
public class DbHelper {
	private static Connection connection;	
	private static String driver = "com.mysql.jdbc.Driver";

    /**
     * Connects to MySQL DB
     * @return connection
     * */
    public static Connection connectToDb() {
    	try {
    		Class.forName(driver);
    		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/smallurl", "root", "");
    	} catch (ClassNotFoundException | SQLException e) {
    		e.printStackTrace();
    	}
    	return connection;
    }

}
