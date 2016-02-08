package ca.albertlockett.alberttwitter.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecurityFilter implements Filter {

	public void init(FilterConfig config) throws ServletException {

	}
	
	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpSession session = servletRequest.getSession();
		
		
		boolean doRedirect = true;
		
		if(servletRequest.getServletPath().equals("/login.html")) {
			doRedirect = false;
		}
		
		if(servletRequest.getServletPath().equals("/signup.html")) {
			doRedirect = false;
		}
		
		// check if user is logged in
		if(session.getAttribute("securityPrinciple") != null) {
			doRedirect = false;
			
		}
		
		if(doRedirect) {
			 ((HttpServletResponse) response).sendRedirect("login.html");
			 return;
		}
		
		chain.doFilter(request, response);
		
	}

	public void destroy() {
		
	}


}
