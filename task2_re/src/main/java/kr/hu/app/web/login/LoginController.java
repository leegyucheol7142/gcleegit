package kr.hu.app.web.login;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	@Qualifier("loginService")
	private LoginService loginService;
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(HttpSession session) {return "login";}
	
	@RequestMapping(value = "success", method = RequestMethod.POST)
	public String success(UserBean ub, HttpSession session) {
		UserBean ub2 = loginService.loginUser(ub);
		System.out.println("con : " + ub);
		session.setAttribute("UserInfo", ub2);
		return "redirect:/";
	}
}