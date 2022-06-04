import java.util.ArrayList;

public class ArrayListInteger {

	public static void main(String[] args) {
		
		ArrayList<Integer> list_first= new ArrayList<Integer>();
		list_first.add(1);
		list_first.add(2);
		list_first.add(3);
		
		// array print
		System.out.println("List : "+list_first.toString());
		
		// array size
		System.out.println("Array size : "+list_first.size());
		
		// contain ? 
		if(list_first.contains(3)) {
			System.out.println("List has the value");
		}else {
			System.out.print("List does not  have the value");
		}
		
		// addAll
		ArrayList<Integer> list_second= new ArrayList<Integer>();
		list_second.add(4);
		list_second.add(5);
		list_second.add(6);
		System.out.println("second list"+list_second.toString());
		
		list_first.addAll(list_second);
		System.out.println("updated first list"+list_first.toString());
		
		// remove
		list_first.remove(4);
		System.out.println("updated first list (after remove)"+list_first.toString());
		
		// iterating
		for(int i=0;i<list_first.size();i++) {
			System.out.println(list_first.get(i));
		}

	}
}
