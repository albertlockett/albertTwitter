package ca.albertlockett.alberttwitter.dao;

import java.util.List;

import ca.albertlockett.alberttwitter.model.User;

public interface UserDao {

	public void saveUser(User user); 
	
	public List<User> searchUsers(User query);
	
	
}
