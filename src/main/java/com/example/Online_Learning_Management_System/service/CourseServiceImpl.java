package com.example.Online_Learning_Management_System.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Online_Learning_Management_System.model.Course;
import com.example.Online_Learning_Management_System.model.CourseDto;
import com.example.Online_Learning_Management_System.model.User;
import com.example.Online_Learning_Management_System.repository.CourseRepository;
import com.example.Online_Learning_Management_System.repository.UserRepository;
@Service
public class CourseServiceImpl implements CourseService{
	@Autowired
	private CourseRepository courseRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	  @Override
	    public void createCourse(CourseDto courseDto) {
	        Course course = new Course();
	        course.setTitle(courseDto.getTitle());
	        course.setDescription(courseDto.getDescription());
	        
	        // Fetch instructor based on ID
	        User instructor = userRepo.findById(courseDto.getInstructorId()).orElse(null);
	        course.setInstructor(instructor);

	        courseRepo.save(course);
	    }
	@Override
	public List<Course> courseList() {
		// TODO Auto-generated method stub
		return courseRepo.findAll();
	}
	
	@Override
	public void enrollCourse(Long userId,Long courseId) {
		Optional<User> optionalUser=userRepo.findById(userId);
		Optional<Course> optionalCourse=courseRepo.findById(courseId);
		User user=optionalUser.get();
		Course course=optionalCourse.get();
		user.getEnrolledCourse().add(course);
		userRepo.save(user);
		
		
	}
	
}
