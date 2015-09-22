package tk.smallurl.controller;

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

import tk.smallurl.model.UrlModel;
import tk.smallurl.utils.DbHelper;

@WebServlet("/LongUrlRedirect")
public class LongUrlRedirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private String longUrl;

	public LongUrlRedirect() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UrlModel urlModelObject = new UrlModel();
		String key = request.getQueryString();
		System.out.println("Small URL Key: " + key);
		connection = DbHelper.connectToDb();

		String query = "select `longUrl` from url where `key`=?";
		try {
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, key);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				urlModelObject.setLongUrl(rs.getString("longUrl"));
			}
			System.out.println(longUrl);
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
