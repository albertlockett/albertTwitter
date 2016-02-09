package ca.albertlockett.alberttwitter.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.albertlockett.alberttwitter.model.User;
import ca.albertlockett.alberttwitter.service.TweetService;
import ca.albertlockett.alberttwitter.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private TweetService tweetService;
	
	@RequestMapping(value="/user/*.html", method=RequestMethod.GET)
	public String viewUserProfile(HttpServletRequest request,
			Model model) {
		
		String path = request.getServletPath();
		String username = path.split("/")[2].split("\\.")[0];
		
		// add user to model
		User user = userService.findUserByName(username);
		model.addAttribute("user", user);
		
		// add user's tweets to model
		model.addAttribute("tweets", tweetService.loadTweetsByUser(user));
		
		return "profile";
		
	}
	
	
}
