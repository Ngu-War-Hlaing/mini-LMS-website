package com.example.Online_Learning_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Online_Learning_Management_System.model.Profile;
import com.example.Online_Learning_Management_System.model.ProfileDto;
import com.example.Online_Learning_Management_System.repository.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService{
	@Autowired
	private ProfileRepository profileRepo;
	
	@Override
	public void createProfile(ProfileDto profileDto) {
		
		Profile profile=new Profile();
		profile.setBio(profileDto.getBio());
		profile.setUser(profileDto.getUser());
		profileRepo.save(profile);
		
	}
	 @Override
	    public List<Profile> getAllProfiles() {
	        return profileRepo.findAll();
	    }
		
}
