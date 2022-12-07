package functional.model;

import java.util.List;

import java.util.stream.Stream;

public class FP03 {
	public static void main(String[] args) {
		printEvenNumbersInListFunctional(List.of(1, 2, 3, 4, 5, 6, 7));
	}

	private static boolean isEven(int number) {
		return number % 2 == 0;
	}

	private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
		numbers.stream()
				.filter(FP03::isEven)
					.forEach(System.out::println);

	}
}
