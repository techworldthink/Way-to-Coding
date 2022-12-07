package strutured.model;

import java.util.List;

public class FP01 {
	public static void main(String[] args) {
		printAllNumbersInListStructured(List.of(1, 2, 3, 4, 5, 6, 7));
	}

	private static void printAllNumbersInListStructured(List<Integer> numbers) {
		for (int number : numbers) {
			System.out.println(number);
		}

	}
}
