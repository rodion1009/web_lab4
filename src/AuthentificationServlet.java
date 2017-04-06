import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AuthentificationServlet
 */
public class AuthentificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthentificationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Writer writer = response.getWriter();
		Object attr = request.getSession(true).getAttribute("logged_in");
		if (attr != null ? (boolean)attr : false) {
			writer.write("<html>Ты уже был залогинен!</html>");
		} else {
			getServletConfig().getServletContext().getRequestDispatcher("/authentification.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginFromForm = request.getParameter("login").toString();
		String passwordFromForm = request.getParameter("password").toString();
		
		String loginFromFile;
		String passwordFromFile;
		
		File f = new File("data.txt");
		FileReader r = new FileReader(f);
		BufferedReader reader = new BufferedReader(r);
		loginFromFile = reader.readLine();
		passwordFromFile = reader.readLine();
		reader.close();
		
		Writer writer = response.getWriter();
		
		if(loginFromForm.equals(loginFromFile) && passwordFromForm.equals(passwordFromFile)) {
			//request.setAttribute("logged_in", true); //добавить в сессию информацию о том, что пользователь уже залогинен
			request.getSession().setAttribute("logged_in", true);
			getServletConfig().getServletContext().getRequestDispatcher("/logged_in.jsp").forward(request, response);
		} else {
			writer.write("<html><h1>Wrong login or password<h1><br><a href=\"AuthentificationServlet\">Try again</a></html>");
		}
		
	}

}
