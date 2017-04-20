package com.wan.basis.user.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.wan.basis.dto.Token;
import com.wan.basis.dto.User;

public interface TokenRepository extends JpaRepository<Token, String>{



}
