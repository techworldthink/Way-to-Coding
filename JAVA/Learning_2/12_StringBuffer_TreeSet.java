import java.util.Set;
import java.util.TreeSet;

import comparator.StringComparator;

public class StringBufferTreeSet {

	public static void main(String[] args) {
		Set<StringBuffer> set = new TreeSet<>();
		set.add(new StringBuffer("abcddf"));
		set.add(new StringBuffer("ab"));
		set.add(new StringBuffer("abc"));
		set.add(new StringBuffer("ddf"));

		for (StringBuffer obj : set) {
			System.out.println(obj);
		}

	}

}
