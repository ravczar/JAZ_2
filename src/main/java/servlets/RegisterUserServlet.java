package servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repositories.UserApplicationRepository;
import web.UserApplication;
import repositories.DummyUserApplicationRepository;


@WebServlet("/register")
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserApplicationRepository repository;
	
	public void init(ServletConfig config) throws ServletException {
		repository = new DummyUserApplicationRepository();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		UserApplication application = retrieveApplicationFromRequest(request, response);
		repository.add(application);
		request.getSession().setAttribute("conf", application); // setAttribute(klucz, wartosc)
		
		response.sendRedirect("success.jsp");
	}

	private UserApplication retrieveApplicationFromRequest (HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		
	// Warunkiem przejscia dalej jest podanie 2 takich samych hase³, inaczej wyswietli sie raport o bledzie
		if (!request.getParameter("password").equals(request.getParameter("conpassword"))) {
			response.sendRedirect("registerError.jsp");
			return null;
		} else {
			UserApplication result = new UserApplication(request.getParameter("username"), request.getParameter("password"), request.getParameter("email"));

	/*	Do skasowania bo zrobilem konstruktor z domyslnym Permission Normal
	 * result.setUsername(request.getParameter("username"));
	 * result.setPassword(request.getParameter("password"));
	 * result.setConpassword(request.getParameter("conpassword"));
	 * result.setEmail(request.getParameter("email"));
	*/	
		return result;
		}
	
	}
	
}
