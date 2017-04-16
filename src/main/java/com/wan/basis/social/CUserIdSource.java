package com.wan.basis.social;

import javax.servlet.http.HttpSession;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.UserIdSource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.wan.basis.dto.User;


public class CUserIdSource implements UserIdSource {

  private static final Logger logger = LoggerFactory.getLogger(CUserIdSource.class);
  
	@Override
	public String getUserId() {
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		String result = null;
		if (authentication == null) {
			throw new IllegalStateException(
					"Unable to get a ConnectionRepository: no user signed in");
		}
		try {
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			result = user.getUsername();	//user PID
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		if(result == null){
			result= String.valueOf(getSession().getId());
		}
		return result;
	}
	
	public static HttpSession getSession(){
	    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    HttpSession session = attr.getRequest().getSession();
	    return session;
	}
}
