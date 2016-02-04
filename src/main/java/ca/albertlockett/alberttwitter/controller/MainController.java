package ca.albertlockett.alberttwitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ca.albertlockett.alberttwitter.service.TweetService;

@Controller
public class MainController {

	@Autowired private TweetService tweetService;
	
	@RequestMapping(value="home.html")
	public String getHomePage(Model model) {
		
		model.addAttribute("tweets", tweetService.loadTweets());
		return "home";
	}
	
	
	
}
