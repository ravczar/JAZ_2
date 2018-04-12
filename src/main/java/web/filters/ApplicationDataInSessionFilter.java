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

@WebFilter("/add")
public class ApplicationDataInSessionFilter implements Filter{

	@Override
	public void destroy() {
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		if(session.getAttribute("conf")!=null)
		{
			// ServletRequest jest instancja HTTPServlet ... i jest zrypany wiec trzeba uzyc tego by przejsc do innej strony
			// response.getWriter().print("Twoje zgloszenie zostalo juz przeslane.");
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.sendRedirect("registeredAlready.jsp");
			return;
		}
		chain.doFilter(request, response);
	}
	
}
