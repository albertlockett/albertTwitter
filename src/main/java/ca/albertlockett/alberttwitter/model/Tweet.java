package ca.albertlockett.alberttwitter.model;

import java.util.Date;

public class Tweet {

	private User user;
	private String content;
	private Date time;
	
	// GETTERS & SETTERS
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
}
