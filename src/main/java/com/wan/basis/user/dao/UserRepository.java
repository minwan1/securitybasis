package com.wan.basis.user.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.wan.basis.dto.User;


public interface UserRepository extends JpaRepository<User, String> {

	public User findByusername(String username);

}
