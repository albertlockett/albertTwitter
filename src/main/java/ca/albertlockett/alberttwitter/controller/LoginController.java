package ca.albertlockett.alberttwitter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.albertlockett.alberttwitter.form.LoginForm;
import ca.albertlockett.alberttwitter.model.User;
import ca.albertlockett.alberttwitter.service.InvalidCredentialsException;
import ca.albertlockett.alberttwitter.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login.html", method=RequestMethod.GET)
	public String getLoginPage(HttpSession session, Model model) {

		// remove current logged in user from session
		session.removeAttribute("securityPrinciple");

		// add login form to model
		model.addAttribute("loginForm", new LoginForm());
		
		
		// give login page;
		return "login";
	}
	
	
	@RequestMapping(value="/login.html", method=RequestMethod.POST)
	public String getLoginPage(Model model, HttpSession session,
			@Validated @ModelAttribute("loginForm") LoginForm form,
			BindingResult errors) {
		
		// validate rules
		if(errors.hasErrors()) {
			return "login";
		}
		
		// try to login user
		try {
			User user = userService.loginUser(form);
			session.setAttribute("securityPrinciple", user);
		} catch (InvalidCredentialsException e) {
			errors.rejectValue("password", 
					"InvalidCredentials.loginForm.password");
			return "login";
		}
		
		return "redirect:home.html";
	}
	
	
}
