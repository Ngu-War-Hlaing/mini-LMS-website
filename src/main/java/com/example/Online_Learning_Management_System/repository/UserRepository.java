package com.example.Online_Learning_Management_System.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Online_Learning_Management_System.model.User;


public interface UserRepository extends JpaRepository<User,Long>{
	 
}
