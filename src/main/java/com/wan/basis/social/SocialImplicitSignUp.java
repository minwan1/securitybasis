package com.wan.basis.social;

import java.util.UUID;


import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;

import com.wan.basis.dto.User;
import com.wan.basis.user.dao.UserRepository;


public class SocialImplicitSignUp implements ConnectionSignUp {
	
	private UserRepository userRepository;
	
	BCryptPasswordEncoder passwordEncoder;
	
	public SocialImplicitSignUp(UserRepository userRepository,BCryptPasswordEncoder passwordEncoder){
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	private String createUserUuid() { //make uuid
		return UUID.randomUUID().toString();
	}
	
	public String execute(Connection<?> connection) { //If there is no information in userconnection, you will work here.
		User user = new User();
		UserProfile profile = connection.fetchUserProfile();
		user.setUsername(createUserUuid());
		user.setFirstName(profile.getFirstName());
		user.setLastName(profile.getLastName());
		user.setEnabled(true);
		user.setEmail(profile.getEmail());
		String tempPassword = String.valueOf(System.currentTimeMillis());
		
		
		try {
			System.out.println(passwordEncoder.encode(tempPassword));
			user.setPassword(passwordEncoder.encode(tempPassword));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		userRepository.save(user); //my application sign up
		

		return user.getUsername();  //return is userId in userconnection
	}
	
	
}
