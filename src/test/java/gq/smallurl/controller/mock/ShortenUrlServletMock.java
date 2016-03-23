package gq.smallurl.controller.mock;


import org.junit.Test;
import static org.junit.Assert.*;

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

    @Test
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        assertEquals("http://www.somelongaddress.com/",req.getParameter("longUrl"));

    }
}
