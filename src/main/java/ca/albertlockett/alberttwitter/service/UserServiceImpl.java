package ca.albertlockett.alberttwitter.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.albertlockett.alberttwitter.dao.UserDao;
import ca.albertlockett.alberttwitter.form.LoginForm;
import ca.albertlockett.alberttwitter.form.RegisterUserForm;
import ca.albertlockett.alberttwitter.model.User;
import ca.albertlockett.alberttwitter.service.exception.InvalidCredentialsException;
import ca.albertlockett.alberttwitter.service.exception.UserAlreadyExistsException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired 
	private UserDao userDao;
	
	public User registerNewUser(RegisterUserForm form)
			throws UserAlreadyExistsException {
		
		// check if a user exists with that user name
		User query = new User();
		query.setUsername(form.getUsername());
		List<User> existingUsers = userDao.searchUsers(query);
		
		if(existingUsers.size() > 0) {
			throw new UserAlreadyExistsException();
		}
		
		// create new user and save
		User newUser = new User();
		newUser.setUsername(form.getUsername());
		newUser.setJoined(new Date());
		userDao.saveUser(newUser);
		
		return newUser;
	}

	
	public User loginUser(LoginForm form) throws InvalidCredentialsException {
		User query = new User();
		query.setUsername(form.getUsername());
		List<User> users = userDao.searchUsers(query);
		
		if(users.size() == 0) {
			throw new InvalidCredentialsException();
		}
		
		return users.get(0);
	}

	public User findUserByName(String username) throws IllegalStateException, 
			IllegalArgumentException {
		
		if(username == null || "".equals(username)) {
			throw new IllegalStateException("username cannot be null");
		}
		
		User query = new User();
		query.setUsername(username);
		List<User> users = userDao.searchUsers(query);
		
		if(users.size() > 1) {
			throw new IllegalStateException("Multiple users with ID " + 
					username);
		}
		
		if(users.size() == 1) {
			return users.get(0);
		}
		
		return null;
		
		
	}
	
	
}
