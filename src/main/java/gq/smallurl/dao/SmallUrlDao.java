package gq.smallurl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import gq.smallurl.utils.DbHelper;
import gq.smallurl.utils.RandomStringGenerator;
/**
 * @author  Robin Raju
 * @since Sept 14, 2015
 *
 * */
public class SmallUrlDao {

	private Connection connection;
	private String smallUrl = null;

	/**
	 * @param  longUrl 		The  long URL
	 * @param  remoteAddr  	Remote host IP
	 * @return Shortened URL
	 * @throws SQLException
	 * */
	public String getSmallUrl(String longUrl, String remoteAddr) throws SQLException {
		try {
			connection = DbHelper.connectToDb();
			String query = "insert into url (`longUrl`,`key`,`createDate`,`remoteAddress`) values(?,?,?,?)";
			String generatedKey = RandomStringGenerator.getRandomString(4);
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, longUrl);
			pstmt.setString(2, generatedKey);
			pstmt.setString(3, getCurrentTimestamp().toString());
			pstmt.setString(4, remoteAddr);
			int row = pstmt.executeUpdate();
			if (row > 0) {
				smallUrl = "http://smallurl.gq/" + generatedKey;
			}
		} finally {
			if (connection != null)
				connection.close();
		}
		return smallUrl;
	}

	/**
	 * Get the current time along with date
	 * @return Current TimeStamp
	 * */
	public static Timestamp getCurrentTimestamp() {
		java.util.Date date = new java.util.Date();
		return new Timestamp(date.getTime());
	}
}
