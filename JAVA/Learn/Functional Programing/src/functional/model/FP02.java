package functional.model;

import java.util.List;

import java.util.stream.Stream;

public class FP02 {
	public static void main(String[] args) {
		printAllNumbersInListFunctional(List.of(1, 2, 3, 4, 5, 6, 7));
	}

	private static void printAllNumbersInListFunctional(List<Integer> numbers) {
		numbers.stream().forEach(System.out::println); // method reference

	}
}
