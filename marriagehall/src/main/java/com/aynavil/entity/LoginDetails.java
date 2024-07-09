package com.aynavil.entity;

public class LoginDetails {
	
	
	private Userdetails Username;
	private Userdetails Password;
	public LoginDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginDetails(Userdetails username, Userdetails password) {
		super();
		Username = username;
		Password = password;
	}
	public Userdetails getUsername() {
		return Username;
	}
	public void setUsername(Userdetails username) {
		Username = username;
	}
	public Userdetails getPassword() {
		return Password;
	}
	public void setPassword(Userdetails password) {
		Password = password;
	}
	@Override
	public String toString() {
		return "LoginDetails [Username=" + Username + ", Password=" + Password + "]";
	}
	

}
