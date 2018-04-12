package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repositories.DummyUserApplicationRepository;
import repositories.UserApplicationRepository;
import web.UserApplication;

/**
 * Servlet implementation class PremiumSettings
 */
@WebServlet("/PremiumSettingsServlet")
public class PremiumSettingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PremiumSettingsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserApplication application = retrieveUserFromRequest(request, response);
		UserApplicationRepository repository = new DummyUserApplicationRepository();
		
		if(request.getParameter("premium").equals("add")) {
			repository.setPremium(application);
		} else {
			repository.removePremium(application);
		}
		
		response.sendRedirect("/ShowAllUsersServlet");
	}
	
	private UserApplication retrieveUserFromRequest (HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		UserApplication result = new UserApplication(null, null);
		result.setUsername(request.getParameter("username"));
		return result;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
