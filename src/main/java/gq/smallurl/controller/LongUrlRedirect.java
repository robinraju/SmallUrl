package gq.smallurl.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gq.smallurl.model.UrlModel;
import gq.smallurl.utils.DbHelper;

/**
 * @author  Robin Raju
 * @since Sept 14, 2015
 *
 * */
@WebServlet("/LongUrlRedirect")
public class LongUrlRedirect extends HttpServlet {

	private Connection connection;
	private String longUrl;

	public LongUrlRedirect() {
		super();
	}

	/**
	 * Redirects the small URl to its corresponding long URL.
	 *
	 * @param request  Servlet Request
	 * @param response the servlet response
	 * */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UrlModel urlModelObject = new UrlModel();
		String key = request.getQueryString();
		connection = DbHelper.connectToDb();

		String query = "select `longUrl` from url where `key`=?";
		try {
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, key);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				urlModelObject.setLongUrl(rs.getString("longUrl"));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		longUrl = urlModelObject.getLongUrl();
		if (longUrl != null) {
			response.sendRedirect(longUrl);
		} else if (longUrl == null) {
			response.sendRedirect("404.jsp");
		}

	}
}
