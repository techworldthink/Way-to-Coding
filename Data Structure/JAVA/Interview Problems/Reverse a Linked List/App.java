
public class App {

	public static void main(String[] args) {

		LinkedList<String> names = new LinkedList<>();

		names.insert("A");
		names.insert("B");
		names.insert("C");
		names.insert("D");

		System.out.println("Before reverse :: ");
		names.traverse();

		names.reverse();

		System.out.println("After reverse :: ");
		names.traverse();

	}
}
