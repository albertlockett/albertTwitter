package ca.albertlockett.alberttwitter.service;

import java.util.List;

import ca.albertlockett.alberttwitter.model.Tweet;

public interface TweetService {

	public List<Tweet> loadTweets();
	
}