package maps;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapDemo {

	public static void main(String[] args) throws InterruptedException {

		Map<User, String> map = new WeakHashMap<>();

		User u = new User(); // 123
		map.put(u, "Tom");

		System.out.println(map);

		u = null;

		System.gc();
		Thread.sleep(5000);

		System.out.println(map);

	}

}
