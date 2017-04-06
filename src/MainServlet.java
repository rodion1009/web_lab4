import java.io.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("logged_in") != null) {
			//отправлять на залогиненную страницу
			//request.getRequestDispatcher("/logged_in.jsp").forward(request, response);
			getServletConfig().getServletContext().getRequestDispatcher("/logged_in.jsp").forward(request, response);
		} else {
			getServletConfig().getServletContext().getRequestDispatcher("/registration.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login").toString();
		String password = request.getParameter("password").toString();
		
		File f = new File("data.txt");
		FileWriter writer = new FileWriter(f);
		writer.write(login + "\n" + password + "\n");
		writer.close();
		
		getServletConfig().getServletContext().getRequestDispatcher("/regComplete.jsp").forward(request, response);
	}

}
