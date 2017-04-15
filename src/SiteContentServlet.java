import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.mirea.web.*;

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
		// TODO Auto-generated method stub
		response.getWriter().write("<html>Now I only can show this text<br></html>");
		Object typeAttr = request.getAttribute("type");
		String type;
		LinkedList<User> users = getUsers();
		if (users != null) {
			request.getSession().setAttribute("users", users);
		}
		if (typeAttr != null) { 
			type = typeAttr.toString();
			if (type.equals("common")) {
				response.getWriter().write("<html>You are a common user</html>");
				getServletConfig().getServletContext().getRequestDispatcher("/testContent.jsp").forward(request, response);
			} else if (type.equals("admin")) {
				response.getWriter().write("<html>You are an admin</html>");
			}
		} else {
			response.getWriter().write("<html><br>An error occur</html>"); 
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private LinkedList<User> getUsers() throws IOException {
		File file = new File("/Users/rodion/Documents/workspace/Lab/data.txt");
		FileReader r;
		BufferedReader reader;
		LinkedList<User> users = new LinkedList<User>();
		
		r = new FileReader(file);
		reader = new BufferedReader(r);
		
		User user = new User();
		
		while ((user.login = reader.readLine()) != null) {
			try {
				user.login = reader.readLine();
				user.password = reader.readLine();
				user.type = reader.readLine();
			} catch (IOException e) {
				return null;
			}
			users.add(user);
		}
		
		reader.close();
		r.close();
		
		return users;
	}
}
