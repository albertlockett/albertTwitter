package ca.albertlockett.alberttwitter.service;

import ca.albertlockett.alberttwitter.form.LoginForm;
import ca.albertlockett.alberttwitter.form.RegisterUserForm;
import ca.albertlockett.alberttwitter.model.User;

public interface UserService {

	public User registerNewUser(RegisterUserForm form) 
			throws UserAlreadyExistsException;

	
	public User loginUser(LoginForm form) 
			throws InvalidCredentialsException;
	
	
}
