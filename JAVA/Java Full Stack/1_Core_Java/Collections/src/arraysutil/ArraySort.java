package arraysutil;

import java.util.Arrays;
import java.util.List;

public class ArraySort {

	public static void main(String[] args) {

		int[] a = { 40, 10, 15, 7 };

		System.out.println("Before sort");
		for (int eachElement : a) {
			System.out.println(eachElement);
		}

		Arrays.sort(a);

		System.out.println("After sort");
		for (int eachElement : a) {
			System.out.println(eachElement);
		}

		String[] s = { "V", "A", "Z", "P" };

		Arrays.sort(s, new MyComparator());

		for (String eachString : s) {
			System.out.println(eachString);
		}

		List<String> list = Arrays.asList(s);
		s[1] = "Y";
		list.add("O");
		System.out.println(list);

	}

}





