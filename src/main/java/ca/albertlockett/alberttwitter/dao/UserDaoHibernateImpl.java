package ca.albertlockett.alberttwitter.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import ca.albertlockett.alberttwitter.model.User;

public class UserDaoHibernateImpl implements UserDao {

	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void saveUser(User user) {
		this.sessionFactory.getCurrentSession().save(user);
		this.sessionFactory.getCurrentSession().flush();
	}
	
	
	public List<User> searchUsers(User query) {
		
		Criteria crit = this.sessionFactory.getCurrentSession()
				.createCriteria(User.class);
		
		if(query.getUsername() != null && !"".equals(query.getUsername())) {
			crit.add(Restrictions.eq("username", query.getUsername()));
		}
		
		return crit.list();
	}

}
