package com.spring.boot.jpa.course.springdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.jpa.course.Course;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Integer>{

}
