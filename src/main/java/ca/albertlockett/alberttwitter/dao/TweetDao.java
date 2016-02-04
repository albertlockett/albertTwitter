package ca.albertlockett.alberttwitter.dao;

import java.util.List;

import ca.albertlockett.alberttwitter.model.Tweet;

public interface TweetDao {

	void saveTweet(Tweet tweet);

	List<Tweet> loadTweets();

}