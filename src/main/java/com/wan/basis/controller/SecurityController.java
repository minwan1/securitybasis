package com.wan.basis.controller;

import java.text.DateFormat;


import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wan.basis.dto.User;
//import com.wan.basis.user.dao.UserDao;
//import com.wan.user.service.CustomUserDetailsService;

@Controller
@PropertySource("classpath:/jdbc.properties")
public class SecurityController {
	
//	@Autowired
//	CustomUserDetailsService customeUserDetailsService;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
//	@Autowired
//	UserDao dao;
	
	private static final Logger logger = LoggerFactory.getLogger(SecurityController.class);
	@Resource
	private Environment environment;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET) //일단 유저로넘어간다.
	public String home(Locale locale, Model model) {
		return "security/loginForm";
	}
	
//	@RequestMapping(value = "/admin", method = RequestMethod.GET) //유저만 들어갈수있
//	public String moveUser(Locale locale, Model model) {
//		logger.info("Admin");
//		
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		String username = auth.getName();
//		
//		
//		model.addAttribute("username",username);
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
//		
//		return "security/admin";
//	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET) //유저만 들어갈수있
	public String moveAdmin(Locale locale, Model model) {
		logger.info("User");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		
		
		model.addAttribute("username",username);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "security/user";
	}
	
//	
//	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
//	public String welcome(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
//		
//		return "security/welcome";
//	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "security/loginForm";
	}
	
//	@RequestMapping(value = "/age", method = RequestMethod.GET) //유저 정보 불러오는 부분 
//	public String test(Locale locale, Model model) {
//		logger.info("test()");
//		
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		User user = (User)authentication.getPrincipal();
//		System.out.println(user.getAge());
//
//		
//		return "security/user";
//	}
	
//	@ResponseBody
//	@RequestMapping(value = "/create", method = RequestMethod.POST) //회원가입부
//	public String createUser(Locale locale, Model model,String userId,String userPassword) {
//		logger.info("create()");
//		
//		logger.info(passwordEncoder.encode(userPassword));
////		dao.createUser(userId, passwordEncoder.encode(userPassword));
//		
//		return "security/user";
//	}
	
//	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
//	public String loginForm(Locale locale, Model model, @PathVariable String id) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
//		
//		return "security/loginForm";
//	}

}
