package ca.albertlockett.alberttwitter.service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import ca.albertlockett.alberttwitter.model.Tweet;
import ca.albertlockett.alberttwitter.model.User;

@Service
public class TweetServiceImpl implements TweetService {

	public List<Tweet> loadTweets() {
		
		// temporary implementation
		
		User user1 = new User();
		user1.setUsername("terry_lockett");
		
		List<Tweet> tweets = new ArrayList<>();
		
		SecureRandom random  = new SecureRandom();
		
		for(int i = 0; i < 20; i++) {
			Tweet tweet1 = new Tweet();
			tweet1.setContent(new BigInteger(130, random).toString(32));
			tweet1.setTime(new Date());
			tweet1.setUser(user1);
			tweets.add(tweet1);
		}
		
		return tweets;
		
	}
	
}
