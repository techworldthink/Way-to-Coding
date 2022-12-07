import java.util.Set;
import java.util.TreeSet;

import comparator.StringComparator;

public class NavigableTreeSetDemo {

	public static void main(String[] args) {

		TreeSet<Integer> set = new TreeSet<Integer>();

		set.add(10);
		set.add(20);
		set.add(30);
		set.add(40);
		set.add(50);
		set.add(60);

		System.out.println(set);
		System.out.println(set.ceiling(20));
		System.out.println(set.higher(40));
		System.out.println(set.floor(10));
		System.out.println(set.lower(30));
		System.out.println(set.pollFirst());
		System.out.println(set.pollLast());
		System.out.println(set.descendingSet());
		

	}

}
