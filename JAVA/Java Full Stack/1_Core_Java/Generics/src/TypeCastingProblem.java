import java.util.ArrayList;
import java.util.List;

public class TypeCastingProblem {

	public static void main(String[] args) {

		String[] s = new String[10];
		s[0] = "John";
		s[1] = "Rob";

		List<String> l = new ArrayList<>();
		l.add("John");
		l.add("Rob");

		String name = (String) l.get(0);
		String name1 = (String) l.get(1);

	}

}
