package repositories;

import java.util.List;

import web.UserApplication;


public interface UserApplicationRepository {

	UserApplication getApplicationByEmailAddress (String email);
	
	void add (UserApplication application);
	
	boolean logIn(UserApplication application);
	
	List<UserApplication> getUsers();
	
	String getUserEmail(UserApplication application);
	
	String getUserPermission(UserApplication application);
	
	void setPremium (UserApplication application);
	
	void removePremium (UserApplication application);
	
	int count();
	
}
