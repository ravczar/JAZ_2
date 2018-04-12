package repositories;

import java.util.ArrayList;
import java.util.List;
import modul.Permissions;
import web.UserApplication;

public class DummyUserApplicationRepository
	implements UserApplicationRepository{
	
	private static List<UserApplication> db = new ArrayList<UserApplication>();
	
	
	public DummyUserApplicationRepository() {    //Moze konsturktor w UserApplication?
		if (db.isEmpty()) {
			
			UserApplication admin = new UserApplication("admin", "1q2w3e", "admin@int.pl");
			admin.setPermissions(Permissions.ADMIN);
			UserApplication premium = new UserApplication("premium", "1q2w3e", "premium@wp.pl");
			premium.setPermissions(Permissions.ADMIN);
			UserApplication normal = new UserApplication("normal", "1q2w3e", "typowy.janusz@o2.pl");
			normal.setPermissions(Permissions.NORMAL);
				db.add(admin);
				db.add(premium);
				db.add(normal);
		}
	}
	

	@Override
	public void add (UserApplication application) {
		db.add(application);
	}
	
	
	
	public boolean logIn (UserApplication application) {
		for (UserApplication userAppDB : db) {
			if (userAppDB.getUsername().equals(application.getUsername()) && userAppDB.getPassword().equals(application.getPassword())) {
				return true;
			}
		}
		return false;
	}
	
	public List<UserApplication> getUsers() {
		return db;
	}

	public String getUserEmail(UserApplication application) {
		for (UserApplication userAppDB : db) {
			if (userAppDB.getUsername().equals(application.getUsername())) {
				return userAppDB.getEmail();
			}
		}
		return "brak uzytkownika";
	}
	
	public String getUserPermission(UserApplication application) {
		for (UserApplication userAppDB : db) {
			if (userAppDB.getUsername().equals(application.getUsername())) {
				return userAppDB.getPermissions().toString();
			}
		}
		return "brak uzytkownika";
	}
	
	public void setPremium(UserApplication application) {
		for (UserApplication userAppDB : db) {
			if (userAppDB.getUsername().equals(application.getUsername())) {
				userAppDB.setPermissions(Permissions.PREMIUM);
			}
		}
	}
	
	public void removePremium(UserApplication application) {
		for (UserApplication userAppDB : db) {
			if (userAppDB.getUsername().equals(application.getUsername())) {
				userAppDB.setPermissions(Permissions.NORMAL);
			}
		}
	}
	
	
// Pozostalosci ze stargo projektu
	@Override
	public UserApplication getApplicationByEmailAddress (String email) {
		for(UserApplication application : db) {
			if (application.getEmail().equalsIgnoreCase(email))
				return application;
		}
		return null;
	}
	

	
	@Override
	public int count() {
		return db.size();
	}
	
	
	
}
