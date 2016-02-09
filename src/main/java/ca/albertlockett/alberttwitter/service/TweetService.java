package ca.albertlockett.alberttwitter.service;

import java.util.List;

import ca.albertlockett.alberttwitter.model.Tweet;
import ca.albertlockett.alberttwitter.model.User;

public interface TweetService {

	public void saveTweet(Tweet tweet);
	
	public List<Tweet> loadTweets();
	
	public List<Tweet> loadTweetsByUser(User user);
	
}