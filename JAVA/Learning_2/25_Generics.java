import java.awt.List;
import java.util.ArrayList;

public class TypeCastingProblem {

	public static void main(String[] args) {
		ArrayList l = new ArrayList();
		l.add("A");
		l.add("B");
		// no error shown here
		l.add(132);
		
		String l1 = (String) l.get(0);
		String l2 = (String) l.get(1);
		// Exception
		String l3 = (String) l.get(2);

		
		// So Generics Introduced
		ArrayList<String> li = new ArrayList<>();
		li.add("A");
		li.add("B");
		// it will be shown as error
		li.add(132);
	}

}
