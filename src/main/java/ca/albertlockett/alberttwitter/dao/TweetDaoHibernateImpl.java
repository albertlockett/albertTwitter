package ca.albertlockett.alberttwitter.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.core.OrderComparator.OrderSourceProvider;

import ca.albertlockett.alberttwitter.model.Tweet;

public class TweetDaoHibernateImpl implements TweetDao {

	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	public void saveTweet(Tweet tweet) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(tweet);
		this.sessionFactory.getCurrentSession().flush();
	};
	

	@SuppressWarnings("unchecked")
	public List<Tweet> loadTweets() {
		Criteria crit = this.sessionFactory.getCurrentSession()
				.createCriteria(Tweet.class);
		crit.addOrder(Order.desc("time"));
		List<?> results = crit.list();
		return (List<Tweet>) results;
	}
	
}
