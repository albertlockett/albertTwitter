package ca.albertlockett.alberttwitter.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.albertlockett.alberttwitter.dao.TweetDao;
import ca.albertlockett.alberttwitter.model.Tweet;
import ca.albertlockett.alberttwitter.model.User;

@Service
public class TweetServiceImpl implements TweetService {

	@Autowired 
	private TweetDao tweetDao;
	
	public List<Tweet> loadTweets() {
		return tweetDao.loadTweets();
	}

	public void saveTweet(Tweet tweet) {
		tweetDao.saveTweet(tweet);
	}
	
	public List<Tweet> loadTweetsByUser(User user) 
			throws IllegalArgumentException {
		
		if(user == null) {
			throw new IllegalArgumentException("user was null");
		}
		
		return tweetDao.loadTweets().stream()
				.filter(t -> t.getUser().equals(user))
				.collect(Collectors.toList());
		
	}
	
}
