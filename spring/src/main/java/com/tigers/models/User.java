package com.tigers.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("session")
public class User {
	
	String userId;
	String firstName;
	String lastName;
	String phoneNumber;
	String email;
	String password;
	String confirmPassword;
	String userStatusId;
	
	//ArrayList<Card> cards = new ArrayList<Card>();
	public User() {
		super();
	}

	public User(String userId, String firstName, String lastName, String phoneNumber, String email, String password,
			String confirmPassword, String userStatusId) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.userStatusId = userStatusId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public String getUserStatusId() {
		return userStatusId;
	}

	public void setUserStatusId(String userStatusId) {
		this.userStatusId = userStatusId;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + ", password=" + password + ", userStatusId=" + userStatusId + "]";
	}
}
