package gq.smallurl.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gq.smallurl.dao.SmallUrlDao;

/**
 * @author  Robin Raju
 * @since Sept 14, 2015
 *
 * */
@WebServlet("/ShortenUrl")
public class ShortenUrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShortenUrl() {
		super();
	}

	/**
	 * Shorten the given long url into a small one.
	 * This is done by creating a random string of length 4
	 * and then the small URL is created by combining it with
	 * the host URL
	 * eg: http://smallurl.gq/{randomString}
	 *
	 * @param  request  The servlet request
	 * @param  response The servlet response
	 * */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String longUrl = request.getParameter("longUrl");
		String remoteAddr = request.getRemoteAddr();
		SmallUrlDao urlDao = new SmallUrlDao();
		try {
			String smallUrl = urlDao.getSmallUrl(longUrl, remoteAddr);
			PrintWriter out = response.getWriter();
			out.write(smallUrl);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
