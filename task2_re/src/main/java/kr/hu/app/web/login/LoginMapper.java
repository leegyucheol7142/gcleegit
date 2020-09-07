package kr.hu.app.web.login;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {

	UserBean loginUser(UserBean ub);
}
