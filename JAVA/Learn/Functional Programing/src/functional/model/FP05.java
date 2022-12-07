package functional.model;

import java.util.List;

import java.util.stream.Stream;

public class FP05 {
	public static void main(String[] args) {
		printOddNumbersInListFunctional(List.of(1, 2, 3, 4, 5, 6, 7));
	}

	private static void printOddNumbersInListFunctional(List<Integer> numbers) {
		numbers.stream()
		.filter(number -> number % 2 == 1)
		.forEach(System.out::println);

	}
}
