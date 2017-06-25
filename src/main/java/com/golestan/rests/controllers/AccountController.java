package com.golestan.rests.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.golestan.rests.viewmodels.ChangePasswordVM;
import com.golestan.rests.viewmodels.LoginVM;
import com.golestan.rests.viewmodels.UserVM;
import com.golestan.security.SecurityContextHolder;
import com.golestan.service.UserAccountService;

@RestController
@RequestMapping("${api.base.url}"+"/account")
public class AccountController {

	@Autowired
	private UserAccountService userAccountService;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@Validated @RequestBody LoginVM loginVM){
		return new ResponseEntity<>(userAccountService.login(loginVM),HttpStatus.OK);
	}
	
	@PostMapping("/logout")
	public ResponseEntity<?> logOut(){
		SecurityContextHolder.removeCurrentUser();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/change-password")
	public ResponseEntity<?> changePassowrd(@Validated @RequestBody ChangePasswordVM changePasswordVM){
		userAccountService.changePassword(changePasswordVM);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/change-userInfo")
	public ResponseEntity<?> changeUserInfo(@Validated @RequestBody UserVM userVM){
		userAccountService.changeUserInfo(userVM);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
