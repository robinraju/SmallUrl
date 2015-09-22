package tk.smallurl.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
	private static Connection connection;
	
	
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
