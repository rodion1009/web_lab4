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
		Writer writer = response.getWriter();
		writer.write("<html><head><title>Registration</title></head>"
				+ 	 "<body><form name=\"reg\" align=\"middle\" method=\"post\" action=\"MainServlet\"><b>Please, enter new login and password</b><br>"
				+    "<b>Login</b><input type=\"text\" name=\"login\"><br> <b>Password</b><input type=\"text\" name=\"password\"><br><input type=\"submit\" value=\"Send\"></body></html>");
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
		
		Writer outWriter = response.getWriter();
		outWriter.write("<html><h1>User has been registrated</h1><br><a href=\"AuthentificationServlet\">Sing in your account</a></html>");
	}

}
