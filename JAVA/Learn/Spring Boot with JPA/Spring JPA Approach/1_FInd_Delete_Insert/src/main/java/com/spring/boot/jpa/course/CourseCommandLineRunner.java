package com.spring.boot.jpa.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spring.boot.jpa.course.Course;
import com.spring.boot.jpa.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

	@Autowired
	private CourseSpringDataJpaRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.save(new Course(1, "A", "AA"));
		repository.save(new Course(2, "AB", "AA"));
		repository.save(new Course(3, "AC", "AA"));
		repository.save(new Course(4, "AD", "AA"));

		repository.deleteById(1);
		repository.deleteById(4);

		System.out.println(repository.findById(2));
		System.out.println(repository.findById(3));

	}

}
