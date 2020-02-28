package com.company;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.ManyToMany;

import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@Column(name="id")
	Long id;
	
	@ManyToMany
	@JoinTable(
			name = "student_liked_courses",
			joinColumns = @JoinColumn(name = "student_id"), 
			inverseJoinColumns = @JoinColumn(name = "course_id"))
	Set<Course> StudentlikedCourses;
	
	 @OneToMany(mappedBy = "student")
	 private Set<CourseRating> ratings;
	 
	public Student() {}

	public Student(Long id) {
		this.id = id;
	}
	
	public Student(Long id, Set<Course> StudentlikedCourses) {
		this.id = id;
		this.StudentlikedCourses = StudentlikedCourses;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Course> getLikedCourses() {
		return StudentlikedCourses;
	}

	public void setLikedCourses(Set<Course> likedCourses) {
		this.StudentlikedCourses = likedCourses;
	}

	public Set<CourseRating> getRatings() {
		return ratings;
	}

	public void setRatings(Set<CourseRating> ratings) {
		this.ratings = ratings;
	}
	
	
	
}
