package ca.albertlockett.alberttwitter.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;

import ca.albertlockett.alberttwitter.model.Tweet;

public class TweetDaoHibernateImpl implements TweetDao {

	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	public void saveTweet(Tweet tweet) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(tweet);
	}
	

	@SuppressWarnings("unchecked")
	public List<Tweet> loadTweets() {
		Criteria crit = this.sessionFactory.getCurrentSession()
				.createCriteria(Tweet.class);
		List<?> results = crit.list();
		return (List<Tweet>) results;
	}
	
}
