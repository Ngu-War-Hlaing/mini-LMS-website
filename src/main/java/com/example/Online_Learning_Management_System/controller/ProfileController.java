package com.example.Online_Learning_Management_System.controller;

import com.example.Online_Learning_Management_System.model.ProfileDto;
import com.example.Online_Learning_Management_System.model.User;
import com.example.Online_Learning_Management_System.service.ProfileService;
import com.example.Online_Learning_Management_System.service.UserService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    private UserService userService;
    @Autowired
    private ProfileService profileService;

    @GetMapping({ "", "/" })
    public String showUserDashboard(Model model) {
        return "users/index"; // Assuming this is your user dashboard view
    }

    @GetMapping("/create_profile")
    public String showCreatePage(@RequestParam Long userId, Model model) {
        ProfileDto profileDto = new ProfileDto();
        
     // Check if profile already exists for the user
        User user = userService.getUserById(userId);
        if (user.getProfile() != null && user.getProfile().getBio() != null) {
            profileDto.setBio(user.getProfile().getBio());
        }
        model.addAttribute("profileDto", profileDto);
        model.addAttribute("userId", userId);
        return "users/create_profile"; // Assuming this is your create profile form view
    }

    @PostMapping("/create_profile")
    public String createProfile(@Valid @ModelAttribute ProfileDto profileDto, BindingResult result, @RequestParam Long userId) {
        if (result.hasErrors()) {
            return "users/create_profile"; // Return back to form if validation fails
        }

        User user = userService.getUserById(userId); // Assuming getUserById retrieves user by ID
     // Only create profile if it doesn't already exist
        if (user.getProfile() == null) {
            profileDto.setUser(user);
            profileService.createProfile(profileDto);
        }

        return "redirect:/users"; // Redirect to profile listing or dashboard
    }
    
    @GetMapping("/view")
    public String viewUsers(@RequestParam Long userId,Model model) {
    	User users = userService.getUserById(userId);      
        model.addAttribute("users", users);
        return "users/view";
    }
}
