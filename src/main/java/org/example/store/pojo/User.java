package org.example.store.pojo;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.example.store.type.UserType;

public class User {

	private String userName;
	private LocalDateTime joiningDate;
	private UserType userType;

	public User(String userName, LocalDateTime joiningDate, UserType userType) {
		super();
		this.userName = userName;
		this.joiningDate = joiningDate;
		this.userType = userType;
	}

	public User(String userName, UserType userType) {
		super();
		this.userName = userName;
		this.joiningDate = LocalDateTime.now();
		this.userType = userType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDateTime getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDateTime joiningDate) {
		this.joiningDate = joiningDate;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

}
