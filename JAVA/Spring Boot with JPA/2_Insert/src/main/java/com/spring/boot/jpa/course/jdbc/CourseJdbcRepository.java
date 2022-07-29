package com.spring.boot.jpa.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.boot.jpa.course.Course;

@Repository
public class CourseJdbcRepository {

	@Autowired
	private JdbcTemplate springJdbcTemplate;

	private static String INSERT_QUERY =

			"""
				INSERT INTO course(id,name,author)
				VALUES(?,?,?);
			""";

	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_QUERY,
				course.getId(),course.getName(),course.getAuthor());
	}
}
