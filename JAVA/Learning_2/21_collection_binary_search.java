import comparator.MyComparator;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class SortedList {

	public static void main(String[] args) {
		List<String> list = new ArrayList();
		list.add("1");
		list.add("2");
		list.add("s");
		list.add("hai");

		System.out.println(list);
		int result = Collections.binarySearch(list, "s");
		System.out.println(result);

	}

}
