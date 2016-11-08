package com.jikexueyuan.action;

public class LoginAction {

	private String username;
	private String password;

	public String execute() {
		if (username.equals("admin") && password.equals("123")) {
			return "success";
		} else {
			return "fail";
		}
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
}
