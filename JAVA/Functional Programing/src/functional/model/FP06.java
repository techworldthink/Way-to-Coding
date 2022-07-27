package functional.model;

import java.util.List;

import java.util.stream.Stream;

public class FP06 {
	public static void main(String[] args) {
		List<String> courses = List.of("Spring","API","AWS");
		
		courses.stream()
			.forEach(System.out::println);
		
		courses.stream()
			.filter(course -> course.contains("Spring"))
			.forEach(System.out::println);
		
		courses.stream()
			.filter(course -> course.length() > 3)
			.forEach(System.out::println);
	}
}
