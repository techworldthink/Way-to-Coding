package com.spring.boot.jpa.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spring.boot.jpa.course.Course;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	private CourseJdbcRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.insert(new Course(1,"A","AA"));
		repository.insert(new Course(2,"AB","AA"));
		repository.insert(new Course(3,"AC","AA"));
		repository.insert(new Course(4,"AD","AA"));
		
		repository.delete(1);
		repository.delete(4);
		
		System.out.println(repository.selectById(2));
		System.out.println(repository.selectById(3));
	}

}
