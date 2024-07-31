package com.example.Online_Learning_Management_System.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;

public class ProfileDto {
	@NotEmpty(message="Bio is required")
	private String bio;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}


	public ProfileDto(@NotEmpty(message = "Bio is required") String bio)
			 {
		super();
		this.bio = bio;
		
	}

	public ProfileDto() {
		super();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
