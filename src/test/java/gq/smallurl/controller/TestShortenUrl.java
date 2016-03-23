package gq.smallurl.controller;

import gq.smallurl.controller.mock.ShortenUrlServletMock;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Robin Raju
 * @since 2016/03/16
 */

public class TestShortenUrl extends Mockito{
    @Test
    public void testDoPostFromServlet() throws ServletException, IOException{
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("longUrl")).thenReturn("http://www.somelongaddress.com/");
        new ShortenUrlServletMock().doPost(request, response);
        verify(request, atLeast(1)).getParameter("longUrl");
    }
}
