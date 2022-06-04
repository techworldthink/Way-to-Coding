import java.util.ArrayList;
import java.util.Iterator;

public class IteratorDemo {

	public static void main(String[] args) {
		ArrayList<Integer> list_first= new ArrayList<Integer>();
		list_first.add(1);
		list_first.add(2);
		list_first.add(3);
		
		Iterator<Integer> itr = list_first.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
			itr.remove();
		}

	}

}
