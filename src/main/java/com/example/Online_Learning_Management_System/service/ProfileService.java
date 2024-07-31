package com.example.Online_Learning_Management_System.service;

import java.util.List;

import com.example.Online_Learning_Management_System.model.Profile;
import com.example.Online_Learning_Management_System.model.ProfileDto;

public interface ProfileService{
	void createProfile(ProfileDto profileDto);
	List<Profile> getAllProfiles();
	
	

}
