package kr.hu.app.web.signup;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.hu.app.web.login.UserBean;

@Controller
@RequestMapping("/signup")
public class SignupController {
		
		@Autowired
		private SignupService signupService;
		
		@RequestMapping(value = "", method = RequestMethod.GET)
		public String signup(HttpSession session) {return "signup";}

		@RequestMapping(value = "", method = RequestMethod.POST)
		public String signup(UserBean ub) {
			signupService.setUser(ub);
			return "redirect:/login";
		}
}
