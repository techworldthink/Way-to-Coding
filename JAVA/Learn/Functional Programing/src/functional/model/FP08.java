package functional.model;

import java.util.List;

import java.util.stream.Stream;

public class FP08 {
	public static void main(String[] args) {
		List<String> courses = List.of("Spring","API","AWS");
		
		courses.stream()
			.map(course -> course.length())
			.forEach(System.out::println);
	}
}
