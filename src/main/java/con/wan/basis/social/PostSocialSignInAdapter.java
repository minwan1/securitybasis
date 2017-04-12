package con.wan.basis.social;


import javax.inject.Inject;


import javax.servlet.http.HttpServletRequest;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;

//import com.wan.basis.dto.User;
//import com.wan.basis.user.dao.UserDao;



public class PostSocialSignInAdapter implements SignInAdapter {
//	private UserRepository userRepository;

//	@Inject
//	public PostSocialSignInAdapter(UserRepository userRepository) {
//		this.userRepository = userRepository;
//	}
	
//	@Inject
//	UserDao dao;

	@Override
	public String signIn(String localUserId, Connection<?> connection, NativeWebRequest request) {
//		UserProfile profile = connection.fetchUserProfile();
//		User user=null;
//		try {
//			user = dao.read(profile.getEmail());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		HttpServletRequest req = ((ServletWebRequest) request).getRequest();
//		req.getSession().setAttribute("loggedUser", user);
//		return "/"; // will return to postSignInUrl 로그인한이후에 이동될 사이트인듯 
//	}

			UserProfile profile = connection.fetchUserProfile();
			System.out.println(profile);


			return "/";
		}

}
