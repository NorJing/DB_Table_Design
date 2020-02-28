package com.company;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@Column(name="id")
	private Long id;
	
	@ManyToMany(mappedBy = "StudentlikedCourses")
	private Set<Student> likes;
	
	@OneToMany(mappedBy = "course")
	Set<CourseRating> ratings;
	
	public Course() {}
	
	public Course(Long id) {
		this.id = id;
	}

	public Course(Long id, Set<Student> likes) {
		super();
		this.id = id;
		this.likes = likes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Student> getLikes() {
		return likes;
	}

	public void setLikes(Set<Student> likes) {
		this.likes = likes;
	}
	
	
}
