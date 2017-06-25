package com.golestan.rests.viewmodels;

import javax.validation.constraints.NotNull;

public class ChangePasswordVM {

	@NotNull
	public String currentPassword;
	
	@NotNull
	public String newPassWord;
	
	public String confirmPassword;

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public String getNewPassWord() {
		return newPassWord;
	}

	public void setNewPassWord(String newPassWord) {
		this.newPassWord = newPassWord;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


	
	
}
