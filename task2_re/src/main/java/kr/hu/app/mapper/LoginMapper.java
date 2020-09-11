package kr.hu.app.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;

import kr.hu.app.bean.UserBean;

@Mapper
@Qualifier("loginMapper")
public interface LoginMapper {
	UserBean loginUser(UserBean ub);
}
