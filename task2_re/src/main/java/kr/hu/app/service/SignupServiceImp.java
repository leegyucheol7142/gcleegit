package kr.hu.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.hu.app.bean.UserBean;
import kr.hu.app.config.Util;
import kr.hu.app.mapper.SignupMapper;

@Service
public class SignupServiceImp implements SignupService {

	@Autowired
	@Qualifier("signupMapper")
	private SignupMapper signupMapper;

	@Override
	public void setUser(UserBean ub) {
		String plainPasswd = ub.getPassword();
		String hashedPasswd = Util.getHashedString(plainPasswd, "SHA-256");
		ub.setPassword(hashedPasswd);
		signupMapper.setUser(ub);
	}
	
}