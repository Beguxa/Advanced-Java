package com.bookshop.pojos;

public class Login {
	private String user;
	private String pass;
	public Login() {
		this("", "");
	}
	public Login(String user, String pass) {
		this.user = user;
		this.pass = pass;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return String.format("Login [user=%s, pass=%s]", user, pass);
	}
}
