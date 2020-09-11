package kr.hu.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.hu.app.bean.UserBean;
import kr.hu.app.service.LoginService;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	@Qualifier("loginService")
	private LoginService loginService;
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(HttpSession session) {return "login";}
	
	@RequestMapping(value = "success", method = RequestMethod.POST)
	public String success(UserBean ub, HttpSession session){
		UserBean ub2 = loginService.loginMember(ub);
		session.setAttribute("loginuser", ub2);
		return "redirect:/";
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("loginuser");
		return "redirect:/";
	}
}