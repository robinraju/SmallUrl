package tk.smallurl.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tk.smallurl.dao.SmallUrlDao;

@WebServlet("/ShortenUrl")
public class ShortenUrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShortenUrl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

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
