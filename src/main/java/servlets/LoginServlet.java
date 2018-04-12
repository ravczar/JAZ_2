package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repositories.DummyUserApplicationRepository;
import repositories.UserApplicationRepository;
import web.UserApplication;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		UserApplicationRepository repository = new DummyUserApplicationRepository();
		UserApplication application = retrieveUserLoginDataFromRequest(request, response);
		
		if (repository.logIn(application)) {
			session.setAttribute("username", application);
			response.sendRedirect("/UserProfileServlet");    
		} else {
			response.sendRedirect("loginError.jsp");
		}
	}

	private UserApplication retrieveUserLoginDataFromRequest (HttpServletRequest request, HttpServletResponse response)
		 throws IOException {
		UserApplication result = new UserApplication(request.getParameter("username"), request.getParameter("password"));
		return result;
	}
	
	
	
}