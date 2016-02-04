package ca.albertlockett.alberttwitter.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.albertlockett.alberttwitter.dao.UserDao;
import ca.albertlockett.alberttwitter.form.LoginForm;
import ca.albertlockett.alberttwitter.form.RegisterUserForm;
import ca.albertlockett.alberttwitter.model.User;

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

	
	
	
}
