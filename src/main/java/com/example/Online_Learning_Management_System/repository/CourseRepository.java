package com.example.Online_Learning_Management_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Online_Learning_Management_System.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}
