package web;

import modul.Permissions;

public class UserApplication {
	private String username;
	private String password;
	private String conpassword;
	private String email;
	private Permissions permission;
		
	// Konstruktor 1 rejestracji
	public UserApplication(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.conpassword = password;
		this.email = email;
		this.permission = Permissions.NORMAL;
	}
	
	// Konstruktor 2 logowania
	public UserApplication(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}



	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConpassword() {
		return conpassword;
	}
	public void setConpassword(String conpassword) {
		this.conpassword = conpassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Permissions getPermissions() {
		return permission;
	}
	public void setPermissions(Permissions permission) {
		this.permission = permission;
	}
	
	

	
}
