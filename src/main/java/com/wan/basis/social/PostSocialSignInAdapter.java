package com.wan.basis.social;


import javax.inject.Inject;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.NativeWebRequest;

import com.wan.basis.dto.User;
import com.wan.basis.user.dao.UserRepository;

//import com.wan.basis.dto.User;
//import com.wan.basis.user.dao.UserDao;


@Service
public class PostSocialSignInAdapter implements SignInAdapter {
//	private UserRepository userRepository;

//	@Inject
//	public PostSocialSignInAdapter(UserRepository userRepository) {
//		this.userRepository = userRepository;
//	}
	
//	@Inject
//	UserDao dao;
	
	private UserRepository userRepository;
	
	@Inject
	public PostSocialSignInAdapter(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	
	//localUserId is userId in userconnection
	@Override
	public String signIn(String localUserId, Connection<?> connection, NativeWebRequest request) {
		
		User user = userRepository.findByusername(localUserId);
		System.out.println(user.getAuthorities());
		Authentication auth = new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(auth);

		return "/user";
		}

}
