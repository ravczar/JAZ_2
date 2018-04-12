package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import repositories.UserApplicationRepository;
import web.UserApplication;

@RunWith(MockitoJUnitRunner.class)
public class TestRegisterUserServlet extends Mockito {

	@Spy
	UserApplicationRepository repository = mock(UserApplicationRepository.class);
	
	@InjectMocks
	RegisterUserServlet servlet;
	
	
	@Test   /// Test sprawdzajacy czy zostaly dodane dane z formularza
	public void servlet_should_write_info_about_applicant_into_session()
			throws IOException, ServletException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);
		when(request.getSession()).thenReturn(session);
		servlet.doGet(request, response);
		verify(session).setAttribute(eq("conf"), Mockito.any(UserApplication.class));
	}
	
	@Test
	public void servlet_should_properly_redirect_user()
			throws IOException, ServletException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);
		when(request.getSession()).thenReturn(session);
		servlet.doGet(request, response);
		verify(response).sendRedirect("success.jsp");
	}
	
	
	
}
