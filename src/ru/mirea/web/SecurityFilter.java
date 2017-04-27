package ru.mirea.web;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecurityFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		User user = (User)request.getSession().getAttribute("user");
		if (user != null && user.logged_in) {
			if (user.type.equals("common")) {
				req.getRequestDispatcher("commonUserSite.jsp").forward(req, resp);
			} else if (user.type.equals("admin")) {
				req.getRequestDispatcher("adminSite.jsp").forward(req, resp);
			} else {
				resp.getWriter().write("<html><b>An error occur!</b></html>");
			}
		} else {
			((HttpServletResponse)resp).sendRedirect("/Lab/AuthentificationServlet");
		}
		chain.doFilter((ServletRequest)request, resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
