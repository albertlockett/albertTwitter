package ca.albertlockett.alberttwitter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.albertlockett.alberttwitter.dao.TweetDao;
import ca.albertlockett.alberttwitter.model.Tweet;

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
	
}
