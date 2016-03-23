package gq.smallurl.controller.mock;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Robin Raju
 * @since 2016/03/16
 */

public class ShortenUrlServletMock extends HttpServlet {
    public ShortenUrlServletMock() {
        super();
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println(req.getParameter("longUrl"));
    }
}
