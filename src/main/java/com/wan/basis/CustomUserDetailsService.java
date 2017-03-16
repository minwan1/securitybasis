package com.wan.basis;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wan.basis.dto.UserInfo;
import com.wan.basis.dto.UserPermission;
import com.wan.basis.dto.human;


@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Inject
	UserDao dao;

	@Override
	public human loadUserByUsername(String username) throws UsernameNotFoundException {
		human userInfo = null;
		try {
			userInfo = dao.read(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		List<UserPermission> perms = loadPermission(userInfo.getId());
//		List<GrantedAuthority> auth = new ArrayList<>();
//		for (UserPermission perm : perms) {
//			auth.add(new SimpleGrantedAuthority(perm.getName()));
//		}
//		return new User(username, userInfo.getPassword(), auth);
		
		return userInfo;
	}

	private UserInfo findUserInfo(String username) {
		return userMap.get(username);
	}

	private List<UserPermission> loadPermission(String username) {
		return permMap.get(username);
	}

	private Map<String, UserInfo> userMap = new HashMap<>();
	private Map<String, List<UserPermission>> permMap = new HashMap<>();

	public CustomUserDetailsService() {
		userMap.put("system", new UserInfo("system", "시스템", "sys"));
		permMap.put("system", Arrays.asList(new UserPermission(1L, "SYSTEM_USER")));
	}
}
