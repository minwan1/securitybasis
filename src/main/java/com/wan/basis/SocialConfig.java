package com.wan.basis;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInController;
import org.springframework.social.connect.web.ReconnectFilter;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.google.connect.GoogleConnectionFactory;

import com.wan.basis.social.CUserIdSource;
import com.wan.basis.social.PostSocialSignInAdapter;
import com.wan.basis.social.SocialImplicitSignUp;
import com.wan.basis.user.dao.UserRepository;

@ComponentScan
@EnableSocial
@Configuration
public class SocialConfig implements SocialConfigurer {
	@Inject
	private DataSource dataSource;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PostSocialSignInAdapter postSocialSignInAdapter;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public UserIdSource getUserIdSource() {
		return new CUserIdSource();
	}

	@Override
	public void addConnectionFactories(ConnectionFactoryConfigurer cfConfig, Environment env) {
		String appKey = "";
		String appSecret = "";

		cfConfig.addConnectionFactory(new FacebookConnectionFactory(appKey, appSecret));
		cfConfig.addConnectionFactory(new GoogleConnectionFactory("",""));
	}

	@Override
	public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
		JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(dataSource,
				connectionFactoryLocator, Encryptors.noOpText());
		repository.setConnectionSignUp(new SocialImplicitSignUp(userRepository,passwordEncoder));
		return repository;
	}

	@Bean
	@Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
	public Facebook facebook(ConnectionRepository repository) {
		Connection<Facebook> connection = repository.findPrimaryConnection(Facebook.class);
		return connection != null ? connection.getApi() : null;
	}
	
	@Bean
	public ReconnectFilter apiExceptionHandler(UsersConnectionRepository usersConnectionRepository,
			UserIdSource userIdSource) {
		return new ReconnectFilter(usersConnectionRepository, userIdSource);
	}


	@Bean
	public ProviderSignInController providerSignInController(ConnectionFactoryLocator connectionFactoryLocator,
			UsersConnectionRepository usersConnectionRepository) {
		ProviderSignInController providerSignInController = new ProviderSignInController(connectionFactoryLocator,
				usersConnectionRepository, postSocialSignInAdapter);
		providerSignInController.setSignUpUrl("/");
		return providerSignInController;
	}

}
