package com.example.Online_Learning_Management_System.service;

import java.util.List;

import com.example.Online_Learning_Management_System.model.User;
import com.example.Online_Learning_Management_System.model.UserDto;

public interface UserService {
	User createUser(UserDto userdto);
	List<User> getAllUsers();
	User getUserById(User instructor);
	User getUserById(Long userId);
	
	
}
