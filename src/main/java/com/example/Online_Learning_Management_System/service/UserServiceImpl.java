package com.example.Online_Learning_Management_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Online_Learning_Management_System.model.User;
import com.example.Online_Learning_Management_System.model.UserDto;
import com.example.Online_Learning_Management_System.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Override
    public User createUser(UserDto userdto) {
        User user = new User();
        user.setUsername(userdto.getUsername());
        user.setPassword(userdto.getPassword());
        user.setEmail(userdto.getEmail());
        user.setRole(userdto.getRole());       
        return repo.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> userOptional = repo.findById(userId);
        return userOptional.orElse(null); // Return null if user is not found
    }


	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	

	@Override
	public User getUserById(User instructor) {
		// TODO Auto-generated method stub
		return null;
	}


}
