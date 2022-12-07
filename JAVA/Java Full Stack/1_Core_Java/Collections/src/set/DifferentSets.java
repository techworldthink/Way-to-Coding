package set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class DifferentSets {

	public static void main(String[] args) {

		Random obj = new Random();

		// HashSet<Integer> set = new HashSet<>();

		// LinkedHashSet<Integer> set = new LinkedHashSet<>();

		Set<Integer> set = new TreeSet<>();

		for (int i = 1; i <= 5; i++) {
			int number = obj.nextInt(100);
			set.add(number);
			System.out.println(number);
		}

		// System.out.println("HashSet elements" + set);
		// System.out.println("LinkedHashSet elements " + set);
		System.out.println("TreeSet elements " + set);

		Iterator<Integer> itr = set.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next());
			itr.remove();
		}
		System.out.println(set);

	}

}
