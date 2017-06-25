package com.golestan.rests.viewmodels;

import com.golestan.enums.UserType;
import com.golestan.model.User;

public class TokenModel {
	String accessToken;
	Long accessTokenExipreTime;
	String tokenType = "Bearer";
	User user;
	
	
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public Long getAccessTokenExipreTime() {
		return accessTokenExipreTime;
	}
	public void setAccessTokenExipreTime(Long accessTokenExipreTime) {
		this.accessTokenExipreTime = accessTokenExipreTime;
	}
	public String getTokenType() {
		return tokenType;
	}
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
