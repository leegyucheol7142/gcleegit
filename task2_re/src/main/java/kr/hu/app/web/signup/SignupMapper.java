package kr.hu.app.web.signup;

import org.apache.ibatis.annotations.Mapper;

import kr.hu.app.web.login.UserBean;

@Mapper
public interface SignupMapper {
		
		public void setUser(UserBean ub);
}
