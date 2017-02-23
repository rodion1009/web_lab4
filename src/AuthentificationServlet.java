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
		writer.write("<html><head><title>Authentification</title></head>"
				+ 	 "<body><form name=\"reg\" align=\"middle\" method=\"post\" action=\"AuthentificationServlet\"><b>Sign in</b><br>"
				+    "<b>Login</b><input type=\"text\" name=\"login\"><br> <b>Password</b><input type=\"text\" name=\"password\"><br><input type=\"submit\" value=\"Send\"></body></html>");
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
			writer.write("<html><h1>You are succesfully signed in<h1><br><a href=\"MainServlet\">Back to registration</a></html>");
		} else {
			writer.write("<html><h1>Wrong login or password<h1><br><a href=\"AuthentificationServlet\">Try again</a></html>");
		}
		
	}

}
