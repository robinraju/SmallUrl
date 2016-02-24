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
	static String host = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
	static String port = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
	private static String url = "jdbc:mysql://" + host + ":" + port + "/smallurl";
	private static String driver = "com.mysql.jdbc.Driver";

    /**
     * Connects to MySQL DB
     * @return connection
     * */
	public static Connection connectToDb() {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, "admin92ydYPj", "knqRuGBj8_9D");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	/*public static Connection connectToDb() {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/smallurl", "root", "");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}*/

}
