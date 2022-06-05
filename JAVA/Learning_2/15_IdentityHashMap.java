import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

public class IdentityHashMapDemo {

	public static void main(String[] args) {
		Map<Integer, String> map = new IdentityHashMap<>();
		map.put(1, "A");
		map.put(2, "B");

		System.out.println("Data : " + map);

	}

}
