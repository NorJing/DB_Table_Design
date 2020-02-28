package com.company;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class PreDataLoader {

	@Bean 
	public CommandLineRunner dataLoader(StudentRepository sRepo, CourseRepository cRepo,
										CourseRegistrationRepository courseRegistrationRepository) {
		
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				System.out.println("Student data loading");
				Student s1 = new Student(1L);
				Student s2 = new Student(2L);
				Student s3 = new Student(3L);
				sRepo.save(s1);
				sRepo.save(s2);
				sRepo.save(s3);
				
				System.out.println("Course data loading");
				Course c1 = new Course(1L);
				Course c2 = new Course(2L);
				Course c3 = new Course(3L);
		        cRepo.save(c1);
		        cRepo.save(c2);
		        cRepo.save(c3);
		        
		        /*System.out.println("Student like following course");
		        Set<Course> s1LikeCourse = new HashSet<Course>();
		        s1LikeCourse.add(c1); s1LikeCourse.add(c2); s1LikeCourse.add(c3);
		        s1.setLikedCourses(s1LikeCourse);
		        sRepo.save(s1);
		        
		        Set<Course> s2LikeCourse = new HashSet<Course>();
		        s2LikeCourse.add(c2); s2LikeCourse.add(c3);
		        s2.setLikedCourses(s2LikeCourse);
		        sRepo.save(s2);*/

		        // the primary key of rating of student 1 and course 1
		        /*CourseRatingKey courseRatingKey11 = new CourseRatingKey(1L, 1L);
		        CourseRatingKey courseRatingKey12 = new CourseRatingKey(1L, 2L);
		        CourseRatingKey courseRatingKey13 = new CourseRatingKey(1L, 3L);
				CourseRatingKey courseRatingKey21 = new CourseRatingKey(2L, 1L);
				CourseRatingKey courseRatingKey22 = new CourseRatingKey(2L, 2L);
		        CourseRating courseRating11 = new CourseRating(courseRatingKey11, s1, c1, 50);
		        CourseRating courseRating12 = new CourseRating(courseRatingKey12, s1, c2, 80);
				CourseRating courseRating21 = new CourseRating(courseRatingKey21, s2, c1, 82);
				// student2 does not give rate to course 2
				// from db query rate is 0
				CourseRating courseRating22 = new CourseRating(courseRatingKey22, s2, c2);
		        courseRatingRepo.save(courseRating11);
		        courseRatingRepo.save(courseRating12);
				courseRatingRepo.save(courseRating21);
				courseRatingRepo.save(courseRating22);*/

		        // student register course
				CourseRegistration courseRegistration111 = new CourseRegistration(1L, s1, c1, 80);
				courseRegistrationRepository.save(courseRegistration111);
				CourseRegistration courseRegistration211 = new CourseRegistration(2L, s1, c1, 80);
				courseRegistrationRepository.save(courseRegistration211);
				CourseRegistration courseRegistration221 = new CourseRegistration(2L, s2, c1, 70); // not good. it is duplicate
				courseRegistrationRepository.save(courseRegistration221);
				CourseRegistration courseRegistration222 = new CourseRegistration(3L, s2, c2, 65);
				courseRegistrationRepository.save(courseRegistration222);
		        System.out.println("PreDataLoader done");
			}
		};
	 }
	
}
