package gq.smallurl.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author  Robin Raju
 * @since Sept 14, 2015
 *
 * WebFilter created to redirect requests to LongUrlRedirect Servlet.
 * This is needed as the incoming url contains some random string
 * which are not the part of standard URLs in this project.
 * And it helps to serve static content from the servlet container.
 * */
@WebFilter("/*")
public class UrlFilter implements Filter {
	public UrlFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String servletPath = req.getServletPath();

		if (servletPath.contains("/assets")) {
			servletPath = "/index.jsp";
		}

		if (servletPath.equals("/ShortenUrl")) {
			chain.doFilter(request, response);
		} else if (servletPath.equals("/index.jsp")) {
			chain.doFilter(request, response);
		} else if (servletPath.equals("/404.jsp")) {
			chain.doFilter(request, response);
		} else if (servletPath.equals("/LongUrlRedirect")) {
			chain.doFilter(request, response);
		} else {
			res.sendRedirect("LongUrlRedirect?" + servletPath.substring(1));
			return;
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
