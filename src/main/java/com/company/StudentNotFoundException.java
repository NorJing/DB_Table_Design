package com.company;

public class StudentNotFoundException extends RuntimeException {
	
	public StudentNotFoundException(Long id) {
		super("Could not find user=" + id);
	}
}
