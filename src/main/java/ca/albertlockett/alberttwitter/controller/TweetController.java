package ca.albertlockett.alberttwitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.albertlockett.alberttwitter.model.Tweet;
import ca.albertlockett.alberttwitter.service.TweetService;

@Controller
public class TweetController {

	@Autowired
	private TweetService tweetService;
	
	@RequestMapping(value="/newTweet.html", method=RequestMethod.POST)
	public String newTweet(Tweet tweet) {
		tweetService.saveTweet(tweet);
		return "redirect:home.html";
		
	}
	
	
}
