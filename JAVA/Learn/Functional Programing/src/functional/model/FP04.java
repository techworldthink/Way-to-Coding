package functional.model;

import java.util.List;

import java.util.stream.Stream;

public class FP04 {
	public static void main(String[] args) {
		printEvenNumbersInListFunctional(List.of(1, 2, 3, 4, 5, 6, 7));
	}

	private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
		numbers.stream()
		.filter(number -> number % 2 == 0)
		.forEach(System.out::println);

	}
}
