package com.example.Online_Learning_Management_System.model;

import jakarta.validation.constraints.NotEmpty;

public class CourseDto {
	@NotEmpty(message="Title is required")
	private String title;
	
	@NotEmpty(message="Description is required")
	private String description;
	
	private Long instructorId;
	
	private User instructor;
	private User students;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CourseDto(@NotEmpty(message = "Title is required") String title,
			@NotEmpty(message = "Description is required") String description) {
		super();
		this.title = title;
		this.description = description;
	}

	public CourseDto() {
		super();
	}

	public User getInstructor() {
		return instructor;
	}

	public void setInstructor(User instructor) {
		this.instructor = instructor;
	}

	public User getStudents() {
		return students;
	}

	public void setStudents(User students) {
		this.students = students;
	}

	public Long getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(Long instructorId) {
		this.instructorId = instructorId;
	}
	
	
	
	
	
}
