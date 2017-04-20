package com.wan.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wan.basis.dto.User;
import com.wan.basis.user.dao.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	private static final String UUID_PATTERN = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}";
	
	@Autowired
	private UserRepository userRepository;
	
	// 디비에서 유저정보를 불러오는메소 이것을 AuthenticationProvider에서 인증을통함
	@Override
	public User loadUserByUsername(String email) throws UsernameNotFoundException {
		User userInfo = null;
		try {
			//userInfo = userRepository.findByemail(email); //디비 정보를 불러와 유저정보 조
			userInfo = userRepository.findByemail(email); //디비 정보를 불러와 유저정보 조
			
			if(userInfo==null && email.matches(UUID_PATTERN)){
				userInfo = userRepository.findByusername(email);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		List<UserPermission> perms = loadPermission(userInfo.getId()); 사용자권한을 불러온다.
//		List<GrantedAuthority> auth = new ArrayList<>();
//		for (UserPermission perm : perms) {
//			auth.add(new SimpleGrantedAuthority(perm.getName()));
//		}
//		return new User(username, userInfo.getPassword(), auth);
		
		return userInfo;
	}
}
