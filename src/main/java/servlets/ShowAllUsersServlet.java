package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modul.HtmlUtils;
import repositories.DummyUserApplicationRepository;
import repositories.UserApplicationRepository;
import web.UserApplication;

/**
 * Servlet implementation class AllUsersServlet
 */
@WebServlet("/ShowAllUsersServlet")
public class ShowAllUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		UserApplicationRepository repository = new DummyUserApplicationRepository();
		
		List<UserApplication> registeredUsers = repository.getUsers();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
	    	HtmlUtils hu = new HtmlUtils();
	    
	    	out.println("<br> <br> <br> <br> <br> <br> <br>");
	    	out.println("<br> <br> <br> <br> <br> <br> <br>");

	    	out.println("<title>All Users</title>");
	    	out.print(hu.createHtmlHeader("Print Table"));

	    	out.print(hu.getTableHead("center", 1));

	    	out.print(hu.getTH("center", "User Name"));
	    	out.print(hu.getTH("center", "User Mail"));
	    	out.print(hu.getTH("center", "Status"));

    		out.println("Na czas sprawdzania:Wszyscy widoczni uzytkownicy 'Admin, Premium oraz Normal' maja haslo : <b>1q2w3e</b>");
	    	
	    	Vector<String> av = new Vector<String>();
	    for (UserApplication user : registeredUsers) {
	    	// Zamieniamy Int Permission.getValue na String by poprawie wyswietlac w Vector
	    	String perm = String.valueOf(user.getPermissions());
	    		av.addElement(user.getUsername());
	    		av.addElement(user.getEmail());
	    		av.addElement(perm);
	    }
	    
	    		
	    av.addElement("<center>" + "<a href=\"/index.jsp\"><input type=\"submit\" value=\"Back to main page\">" + "</center>");
	    	out.print(hu.getTableContents("center", av, 3));
	    	out.print(hu.getHtmlFooter());
	
	}

}