package kr.hu.app.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.hu.app.bean.UserBean;

@Mapper
public interface SignupMapper {
		
		public void setUser(UserBean ub);
}
