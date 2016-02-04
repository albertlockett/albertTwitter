package ca.albertlockett.alberttwitter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.albertlockett.alberttwitter.form.TweetForm;

@Controller
public class TweetController {

	@RequestMapping(value="/newTweet.html", method=RequestMethod.POST)
	public String newTweet(TweetForm form) {
		
		System.err.println(form.getContent());
		return "redirect:home.html";
		
	}
	
	
}
