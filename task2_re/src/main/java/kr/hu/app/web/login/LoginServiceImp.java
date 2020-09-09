package kr.hu.app.web.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImp implements LoginService {
	
	@Autowired
	@Qualifier("loginMapper")
	private LoginMapper loginMapper;
	
	@Override
	public UserBean loginUser(UserBean ub) {
		System.out.println("LoginService : " + ub);
		UserBean ub2 = loginMapper.loginUser(ub);
		return ub2;
		
	}
}	
