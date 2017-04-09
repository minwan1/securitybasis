package com.wan.basis;

import javax.inject.Inject;


import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.wan.basis.dto.User;

//
//@Repository
//public class UserDao {
//	
//	@Inject
//	private SqlSession session;
//	
//	private static String namespace = "org.zerock.mapper.BoardMapper";
//	
//	public void create(User user) throws Exception{
//		session.insert(namespace+".create" , user);
//	
//	}
//	
//	public User read(String username) throws Exception{
//		User user = null;
//		try {
//			user = (User) session.selectOne(namespace+".read" , username);
//		} catch (Exception e) {
//			e.printStackTrace();
//			// TODO: handle exception
//		}
//		return user;
//	
//	}
//	
//	public boolean createUser(String userId,String userPassword){
//		User user = new User();
//		user.setAge("33");
//		user.setPassword(userPassword);
//		user.setEnabled(true);
//		user.setUsername(userId);
//		
//		session.insert(namespace+".usercreate",user);
//		
//		return true;
//	}
//
//}
