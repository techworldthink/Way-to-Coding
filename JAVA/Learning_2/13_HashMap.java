import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("A", 12);
		map.put("B", 13);
		map.put("C", 14);

		Set<String> keyset = map.keySet();
		System.out.println("Keys : " + keyset);

		Collection<Integer> values = map.values();
		System.out.println("Values : " + values);

		for (String key : keyset) {
			System.out.println("Key : " + key + "   Value : " + map.get(key));
		}
	}

}
