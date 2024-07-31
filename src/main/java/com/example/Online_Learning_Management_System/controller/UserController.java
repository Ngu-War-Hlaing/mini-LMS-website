package com.example.Online_Learning_Management_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.example.Online_Learning_Management_System.model.Profile;
import com.example.Online_Learning_Management_System.model.User;
import com.example.Online_Learning_Management_System.model.UserDto;
import com.example.Online_Learning_Management_System.service.UserService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping({ "", "/" }) // default mapping
	    public String showUserDashboard(Model model) {  
		List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
	        return "users/index";
	   }
	
	@GetMapping("/create")
	public String showCreatePage(Model model) {
		UserDto userDto = new UserDto();
		model.addAttribute("userDto",userDto);
		return "users/create_user";
	}
	@PostMapping("/create")
    public String createUser(@Valid @ModelAttribute UserDto userDto, BindingResult result,Model model) {
		User createUser = userService.createUser(userDto);
		Profile profile=new Profile();
		model.addAttribute("profile",profile);
		model.addAttribute("userId", createUser.getId());		
    	
        if (result.hasErrors()) {
            return "users/create_user";
        }

        return "redirect:/users";
    }
	
	
	

}
