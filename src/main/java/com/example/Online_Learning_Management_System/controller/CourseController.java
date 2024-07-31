package com.example.Online_Learning_Management_System.controller;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Online_Learning_Management_System.model.Course;
import com.example.Online_Learning_Management_System.model.CourseDto;
import com.example.Online_Learning_Management_System.model.User;
import com.example.Online_Learning_Management_System.service.CourseService;
import com.example.Online_Learning_Management_System.service.UserService;

@Controller
@RequestMapping("/courses")
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping({"","/"})
	public String showCourseList(Model model) {
		List<Course> courses=courseService.courseList();
		
		// Group courses by instructor
        Map<Object, List<Course>> coursesGroupedByInstructor = courses.stream()
                .collect(Collectors.groupingBy(course -> course.getInstructor().getUsername()));
        
		model.addAttribute("coursesGroupedByInstructor", coursesGroupedByInstructor);
		return "users/course_list";
	}
	


	 @GetMapping("/create")
	    public String showCreateForm(Model model) {
	        List<User> instructors = userService.getAllUsers().stream()
	            .filter(user -> "Instructor".equals(user.getRole()))
	            .collect(Collectors.toList());
	        model.addAttribute("courseDto", new CourseDto());
	        model.addAttribute("instructors", instructors);
	        return "users/create_course";
	    }

	    @PostMapping("/create")
	    public String createCourse(@ModelAttribute("courseDto") CourseDto courseDto) {
	        courseService.createCourse(courseDto);
	        return "redirect:/courses"; // Redirect to courses page or appropriate page
	    }

	    @GetMapping("/enroll")
	    public String showEnrollForm(Model model) {
	        List<Course> courses = courseService.courseList();
	        List<User> students = userService.getAllUsers();
	        
	        model.addAttribute("courses", courses);
	        model.addAttribute("students", students);
	        return "users/enroll_course";
	    }

	    @PostMapping("/enroll")
	    public String createEnroll(@RequestParam Long userId, @RequestParam Long courseId) {
	        courseService.enrollCourse(userId, courseId);
	        return "redirect:/courses/enroll";
	    }

	    @GetMapping("/view_enroll_list")
	    public String showEnrollList(Model model) {
	       
	        List<User> students = userService.getAllUsers();
	        
	        model.addAttribute("students", students);
	        return "users/enroll_list";
	    }
	    
	    @GetMapping("/view_enroll_Courselist")
	    public String showEnrollCourseList(Model model) {
	       
	        List<Course> courses = courseService.courseList();
	        
	        model.addAttribute("courses", courses);
	        return "users/enroll_course_list";
	    }

}
