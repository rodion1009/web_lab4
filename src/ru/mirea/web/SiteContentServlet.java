package ru.mirea.web;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SiteContentServlet
 */
public class SiteContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SiteContentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String button = request.getParameter("btn").toString();
		System.out.println(button);
		if (button.equals("Logout")) {
			request.getSession().removeAttribute("user");
			//getServletConfig().getServletContext().getRequestDispatcher("/authentification.jsp").forward(request, response);
			//response.sendRedirect("/AuthentificationServlet");
			
		} else if (button.equals("Delete")) {
			deleteUser(request, response);
			//getServletConfig().getServletContext().getRequestDispatcher("/adminSite.jsp").forward(request, response);
			//doGet(request, response);
		} 
		doGet(request, response);
	}
	
	public static ArrayList<User> getUsers() throws IOException {
		ArrayList<User> users = new ArrayList<User>();
		User user = new User();
		
		List<String> strs = Files.readAllLines(Paths.get("/Users/rodion/Documents/workspace/Lab/data.txt"), StandardCharsets.UTF_8);
		
		for (int i = 0; i < strs.size(); i += 3) {
			user = new User();
			
			user.login = strs.get(i);
			user.password = strs.get(i+1);
			user.type = strs.get(i+2);

			users.add(user);
		}
		
		return users;
	}
	
	public static void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		File f = new File("/Users/rodion/Documents/workspace/Lab/data.txt");
		
		List<String> users = Files.readAllLines(Paths.get(f.getPath()), StandardCharsets.UTF_8);
		String user;
		try {
			user = request.getParameter("user").toString();
		} catch (NullPointerException e) {
			return;
		}
		int i = 0;
		
		while (!users.get(i).equals(user)) {
			i++;
		}
		
		try {
			for (int j = 0; j < 3; j++) {
				users.remove(i);
			}
		} catch (IndexOutOfBoundsException e) {
			request.setAttribute("deleted", false);
			return;
		}
		
		request.setAttribute("deleted", true);
		BufferedWriter buffWriter = new BufferedWriter(new FileWriter(f));
		for (int k = 0; k < users.size(); k++) {
			buffWriter.write(users.get(k) + "\n");
		}
		buffWriter.close();
		//request.getRequestDispatcher("/adminSite").forward(request, response);
		
	}
}
