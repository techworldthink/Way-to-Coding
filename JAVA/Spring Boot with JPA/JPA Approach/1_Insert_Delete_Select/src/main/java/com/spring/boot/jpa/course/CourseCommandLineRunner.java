package com.spring.boot.jpa.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spring.boot.jpa.course.Course;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	private CourseJpaRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.insert(new Course(1,"A","AA"));
		repository.insert(new Course(2,"AB","AA"));
		repository.insert(new Course(3,"AC","AA"));
		repository.insert(new Course(4,"AD","AA"));
		
		repository.deleteById(1);
		repository.deleteById(4);
		
		System.out.println(repository.selectById(2));
		System.out.println(repository.selectById(3));
	}

}
