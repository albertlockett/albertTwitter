package ca.albertlockett.alberttwitter.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.albertlockett.alberttwitter.form.RegisterUserForm;
import ca.albertlockett.alberttwitter.model.User;
import ca.albertlockett.alberttwitter.service.UserService;
import ca.albertlockett.alberttwitter.service.exception.UserAlreadyExistsException;

@Controller
public class RegistrationController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/signup.html", method=RequestMethod.GET)
	public String getSignupPage(HttpSession session, Model model) {
		
		// remove current loggged in user from session
		session.removeAttribute("securityPrinciple");
		
		// add form object to model
		model.addAttribute("registrationForm", new RegisterUserForm());
		
		// give signup page
		return "signup";
	}
	
	
	@RequestMapping(value="/signup.html", method=RequestMethod.POST)
	public String signUp(HttpServletRequest request, Model model,
			@Validated @ModelAttribute("registrationForm")RegisterUserForm form, 
			BindingResult errors) {
		
		// validate errors
		if(errors.hasErrors()) {
			return "signup";
		}
		
		try {
			
			// save user and add to session
			User user = userService.registerNewUser(form);
			request.getSession().setAttribute("securityPrinciple", user);
		} catch(UserAlreadyExistsException e) {
			
			// inform user that we couldn't create a new user for them
			errors.rejectValue("username", 
					"UserAlreadyExists.registrationForm.username");
			return "signup";
		}
		
		// send to home screen
		return "redirect:home.html";
	}
	
}
