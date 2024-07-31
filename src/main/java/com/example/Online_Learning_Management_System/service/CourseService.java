package com.example.Online_Learning_Management_System.service;

import java.util.List;

import com.example.Online_Learning_Management_System.model.Course;
import com.example.Online_Learning_Management_System.model.CourseDto;

public interface CourseService {
	void createCourse(CourseDto courseDto);
	List<Course> courseList();

	void enrollCourse(Long userId, Long courseId);
	
	
	
}
