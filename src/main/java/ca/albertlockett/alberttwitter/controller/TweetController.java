package ca.albertlockett.alberttwitter.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.albertlockett.alberttwitter.model.Tweet;
import ca.albertlockett.alberttwitter.model.User;
import ca.albertlockett.alberttwitter.service.TweetService;

@Controller
public class TweetController {

	@Autowired
	private TweetService tweetService;
	
	@RequestMapping(value="/newTweet.html", method=RequestMethod.POST)
	public String newTweet(Tweet tweet, HttpSession session) {
		
		// find who tweeted
		User currentUser = (User) session.getAttribute("securityPrinciple");
		if(currentUser == null) {
			return "redirect:login.html";
		}
		
		// set other tweet information
		tweet.setUser(currentUser);
		tweet.setTime(new Date());
		
		// save and return
		tweetService.saveTweet(tweet);
		return "redirect:home.html";
		
	}
	
	
}
