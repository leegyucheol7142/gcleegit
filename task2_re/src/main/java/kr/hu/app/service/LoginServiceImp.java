package kr.hu.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.hu.app.bean.UserBean;
import kr.hu.app.config.Util;
import kr.hu.app.mapper.LoginMapper;

@Service
public class LoginServiceImp implements LoginService {
	
	@Autowired
	@Qualifier("loginMapper")
	private LoginMapper loginMapper;
	
	@Override
	public UserBean loginMember(UserBean ub) {
		
		String plainPasswd = ub.getPassword();
		String hashedPasswd = Util.getHashedString(plainPasswd, "SHA-256");
		ub.setPassword(hashedPasswd);
		UserBean ub2 = loginMapper.loginUser(ub);
		return ub2;
		
	}
}	
