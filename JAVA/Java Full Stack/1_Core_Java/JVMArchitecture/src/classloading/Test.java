package classloading;
import java.lang.reflect.Method;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException {

		Class c = Class.forName("User");

		Method[] methods = c.getDeclaredMethods();

		for (Method method : methods) {
			System.out.println(method.getName());
		}
		System.out.println(methods.length);

	}

}
