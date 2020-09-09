package kr.hu.app.web.login;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;

@Mapper
@Qualifier("loginMapper")
public interface LoginMapper {

	UserBean loginUser(UserBean ub);
}
