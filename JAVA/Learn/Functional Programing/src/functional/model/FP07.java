package functional.model;

import java.util.List;

import java.util.stream.Stream;

public class FP07 {
	public static void main(String[] args) {
		printSquaresOfAllNumbersInListFunctional(List.of(1, 2, 3, 4, 5, 6, 7));
	}

	private static void printSquaresOfAllNumbersInListFunctional(List<Integer> numbers) {
		numbers.stream()
		.map(number -> number * number)
		.forEach(System.out::println); 

	}
}
