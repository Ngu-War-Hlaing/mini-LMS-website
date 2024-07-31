package com.example.Online_Learning_Management_System.model;

import jakarta.validation.constraints.NotEmpty;

public class UserDto {
	@NotEmpty(message="Username is required")
	private String username;
	
	@NotEmpty(message="Password is required")
	private String password;
	
	@NotEmpty(message="Email is required")
	private String email;
	
	@NotEmpty(message="Role is required")
	private String role;
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public UserDto(@NotEmpty(message = "Username is required") String username,
			@NotEmpty(message = "Password is required") String password,
			@NotEmpty(message = "Email is required") String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		
	}

	public UserDto() {
		super();
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

}
