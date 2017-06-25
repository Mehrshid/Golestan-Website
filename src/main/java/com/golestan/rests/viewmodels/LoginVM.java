package com.golestan.rests.viewmodels;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginVM {

	@NotEmpty
	public String userName;
	
	@NotEmpty
	public String password;

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
