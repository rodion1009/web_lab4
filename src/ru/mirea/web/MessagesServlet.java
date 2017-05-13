package ru.mirea.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MessagesServlet
 */
public class MessagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private volatile List<String> messages = new ArrayList<String>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessagesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		for (String message: messages) {
			response.getWriter().print(message + "<br>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = request.getParameter("message").toString();
		User user = (User)request.getSession().getAttribute("user");
		addMessage(message, user.login);
		getServletConfig().getServletContext().getRequestDispatcher("/messages.jsp").forward(request, response);			
	}
	
	void addMessage(String message, String username) {
		message = "[" + username + "]: " + message;
		synchronized(this) {
			messages.add(message);
		}
	}

}
