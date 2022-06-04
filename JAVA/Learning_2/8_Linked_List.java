import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {

	public static void main(String[] args) {

		Object objects[] = new Object[1000000];

		for (int i = 0; i < objects.length; i++) {
			objects[i] = new Object();
		}
		
		// Arra
		LinkedList<Object> list = new LinkedList();
		long start = System.currentTimeMillis();
		for (Object object : objects) {
			list.add(objects);
		}
		long end = System.currentTimeMillis();
		System.out.println("Time taken : " + (end - start));
		
		// insert
		start = System.currentTimeMillis();
		list.set(2,new Object());
		end = System.currentTimeMillis();
		System.out.println("Time taken : " + (end - start));

	}

}
