package com.example.Online_Learning_Management_System.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	private String username;
	private String password;
	private String email;
	private String role;
	
	
	//connect User and Profile as one to one
	@OneToOne(mappedBy = "user" , cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
	private Profile profile;
	
	//connect Course and Instructor
	@OneToMany(mappedBy = "instructor",cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
	private Set<Course> instructedCourse=new HashSet<>();
	
	//connect User and Course
	@ManyToMany(cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
	@JoinTable(name="enrollments",
				joinColumns=@JoinColumn(name="user_id"),
				inverseJoinColumns=@JoinColumn(name="course_id"))
	private Set<Course> enrolledCourse=new HashSet<>();
	

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public User(long id, String username, String password, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		
	}
	public User() {
		super();
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Set<Course> getInstructedCourse() {
		return instructedCourse;
	}
	public void setInstructedCourse(Set<Course> instructedCourse) {
		this.instructedCourse = instructedCourse;
	}
	public Set<Course> getEnrolledCourse() {
		return enrolledCourse;
	}
	public void setEnrolledCourse(Set<Course> enrolledCourse) {
		this.enrolledCourse = enrolledCourse;
	}
	
	

	
	
	
	

}
