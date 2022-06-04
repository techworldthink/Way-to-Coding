import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class HashSetDemo {

	public static void main(String[] args) {
		ArrayList<Integer> list_first = new ArrayList<Integer>();
		list_first.add(1);
		list_first.add(2);
		list_first.add(3);
		list_first.add(3);
		System.out.println("List : " + list_first);

		// Set
		Set<Integer> set = new HashSet<>(list_first);
		System.out.println("Set : " + set);
		
		// LinkedHashSet
		LinkedHashSet<Integer> linkedhashset = new LinkedHashSet<>(list_first);
		System.out.println("LinkedHashSet : " + linkedhashset);
		
		// TreeSet
		Set<Integer> treeset = new TreeSet<>(list_first);
		System.out.println("TreeSet : " + treeset);
	}

}
