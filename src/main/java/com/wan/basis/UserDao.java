package com.wan.basis;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import com.wan.basis.dto.human;


@Repository
public class UserDao {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "org.zerock.mapper.BoardMapper";
	
	public void create(User user) throws Exception{
		session.insert(namespace+".create" , user);
	
	}
	
	public human read(String username) throws Exception{
		human user = null;
		try {
			user = (human) session.selectOne(namespace+".read" , username);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return user;
	
	}

}
