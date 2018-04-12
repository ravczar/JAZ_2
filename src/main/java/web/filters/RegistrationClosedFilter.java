package web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import repositories.DummyUserApplicationRepository;


@WebFilter(urlPatterns = {"/", "/add"}, servletNames="AddApplicantServlet ")
public class RegistrationClosedFilter implements Filter{

	@Override
	public void destroy() {

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/*
		* Filtr Pozwoli zarejestrowac '6' u¿ytkowników in total
		*/ 
		if(new DummyUserApplicationRepository().count()>5) {

				// ServletRequest jest instancja HTTPServlet wiec trzeba uzyc tego by przejsc do innej strony
				// response.getWriter().print("Rejestracja na konferencje zakonczyla sie.");
			 HttpServletResponse httpResponse = (HttpServletResponse) response;
			 httpResponse.sendRedirect("registrationEnd.jsp");
			
			return;
		}
		chain.doFilter(request, response);
	}



}
