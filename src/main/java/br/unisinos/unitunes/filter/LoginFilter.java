package br.unisinos.unitunes.filter;

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

@WebFilter(filterName = "LoginFilter",
	urlPatterns = {"/s/*"})
public class LoginFilter implements Filter {
	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		if (((HttpServletRequest) request).getSession().getAttribute("academic") != null
				|| ((HttpServletRequest) request).getRequestURI().toString() == "/login.jsp") {
			// User is logged in, just continue request.
		    chain.doFilter(request, response); 
		} else {
			 // Not logged in
		    ((HttpServletResponse) response).sendRedirect("/login.jsp");
		}
		
	}
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
