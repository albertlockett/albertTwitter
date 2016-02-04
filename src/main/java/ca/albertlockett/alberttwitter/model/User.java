package ca.albertlockett.alberttwitter.model;

import java.util.Date;

public class User {

	private Long userId;
	private String username;
	private Date joined;
	

	// GETTERS & SETTERS
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getJoined() {
		return joined;
	}
	public void setJoined(Date joined) {
		this.joined = joined;
	}

	
	
}
