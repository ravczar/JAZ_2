package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modul.HtmlUtils;
import repositories.DummyUserApplicationRepository;
import repositories.UserApplicationRepository;
import web.UserApplication;

/**
 * Servlet implementation class UserProfileServlet
 */
@WebServlet("/UserProfileServlet")
public class UserProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		UserApplicationRepository repository = new DummyUserApplicationRepository();
		
		UserApplication application = (UserApplication) session.getAttribute("username");
		
		//response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		    HtmlUtils hu = new HtmlUtils();
		    
		    out.println("<br> <br> <br> <br> <br> <br> <br>");
		    out.println("<br> <br> <br> <br> <br> <br> <br>");
		    out.println("<title>User Profile</title>");
		    out.print(hu.createHtmlHeader("Print Table"));

		    out.print(hu.getTableHead("center", 1));

		    out.print(hu.getTH("center", "User Name"));
		    out.print(hu.getTH("center", "Password"));
		    out.print(hu.getTH("center", "Email"));
		    out.print(hu.getTH("center", "Permission"));

		    Vector<String> av = new Vector<String>();

		    av.addElement(application.getUsername());
		    av.addElement(application.getPassword());
		    av.addElement(repository.getUserEmail(application));
		    av.addElement(repository.getUserPermission(application));
		    
		    av.addElement("<center>" + "<a href=\"/index.jsp\"><input type=\"submit\" value=\"Back to Main Page \">" + "</center>");
		    
		    out.print(hu.getTableContents("center", av, 4));
		    out.print(hu.getHtmlFooter());
		   
	}

}
