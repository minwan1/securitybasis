package con.wan.basis.social;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;

import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;

//import com.wan.basis.dto.User;
//import com.wan.basis.user.dao.UserDao;



public class SocialImplicitSignUp implements ConnectionSignUp {
//	private UserRepository userRepository;
//
//	public SocialImplicitSignUp(UserRepository userRepository){
//		this.userRepository = userRepository;
//	}
	@Autowired
//	UserDao dao;
	
//	@Override
//	public String execute(Connection<?> connection) {
//		UserProfile profile = connection.fetchUserProfile();
////		User user = new User(profile.getFirstName() + " " + profile.getLastName(), profile.getEmail(), "N/A",connection.getImageUrl());
//		
//		User user = new User(profile.getEmail(),"alsdhks12",true,"25");
//		
//		try {
//			dao.create(user);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return user.getUsername();
//	}
//
	private final AtomicLong userIdSequence = new AtomicLong();
	
	public String execute(Connection<?> connection) {
		return Long.toString(userIdSequence.incrementAndGet());
	}
}
