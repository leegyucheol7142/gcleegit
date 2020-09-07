package kr.hu.app.web.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.hu.app.web.login.UserBean;

@Service
public class SignupServiceImp implements SignupService {

	@Autowired
	@Qualifier("signupMapper")
	private SignupMapper signupMapper;

	@Override
	public void setUser(UserBean ub) {
		System.out.println("SignupService : " + ub);
		signupMapper.setUser(ub);
	}
	
}