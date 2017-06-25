package com.golestan.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.golestan.enums.UserType;
import com.golestan.model.Student;
import com.golestan.model.User;
import com.golestan.repositories.UserRepository;
import com.golestan.rests.viewmodels.ChangePasswordVM;
import com.golestan.rests.viewmodels.LoginVM;
import com.golestan.rests.viewmodels.TokenModel;
import com.golestan.rests.viewmodels.UserVM;
import com.golestan.security.SecurityContextHolder;

@Service
public class UserAccountService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtService jwtService;
	
	public TokenModel login(LoginVM loginVM){
		
		Optional<User> optionalUser = userRepository.findByUserName(loginVM.getUserName());
		if(optionalUser.isPresent()){
			if(passwordEncoder.matches( loginVM.getPassword(),optionalUser.get().getPassword())){
				TokenModel tokenModel = jwtService.generateToken(optionalUser.get().getId());
				tokenModel.setUser(optionalUser.get());
				return tokenModel;
			}else{
				throw new RuntimeException("user password is wrong");
			}
			
		}else{
			throw new RuntimeException("user not found");
		}

	}
	
	@Transactional
	public void changePassword(ChangePasswordVM changePasswordVM){
		User currentUser = SecurityContextHolder.currentUser();
		if(passwordEncoder.matches(changePasswordVM.getCurrentPassword(),currentUser.getPassword() )){
				currentUser.setPassword(passwordEncoder.encode(changePasswordVM.getNewPassWord()));
				userRepository.save(currentUser);
		}else{
			throw new RuntimeException("user current password is wrong");
		}
	}
	
	@Transactional
	public void changeUserInfo(UserVM userVM){
		User currentUser = SecurityContextHolder.currentUser();
		currentUser.setFirstname(userVM.getFirstname());
		currentUser.setLastname(userVM.getLastname());
		currentUser.setNationalId(userVM.getNationalId());
		userRepository.save(currentUser);
	}
}
