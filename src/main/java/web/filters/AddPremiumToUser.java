package web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repositories.DummyUserApplicationRepository;
import web.UserApplication;

@WebFilter("/addPremiumToUser.jsp")
public class AddPremiumToUser implements Filter{
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
			
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			HttpSession session = httpRequest.getSession();
			
			if (session.getAttribute("username")!= null) {
				UserApplication application = (UserApplication) session.getAttribute("username");
				DummyUserApplicationRepository repository = new DummyUserApplicationRepository();
				String privilege = repository.getUserPermission(application);
		
			if ( !privilege.equals("ADMIN") ) {
				HttpServletResponse httpResponse = (HttpServletResponse) response;
				httpResponse.sendRedirect("/index.jsp");
				}
			} else {
				HttpServletResponse httpResponse = (HttpServletResponse) response;
				httpResponse.sendRedirect("/index.jsp");
			}
		
			chain.doFilter(request, response);
		}
		
		@Override
		public void destroy() {
		}
		
		@Override
		public void init(FilterConfig arg0) throws ServletException {
		}
}
