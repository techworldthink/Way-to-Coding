
public class App {

	public static void main(String[] args) {
		DoublyLinkedList<String> words = new DoublyLinkedList<>();
		words.insert("ABC");
		words.insert("DEF");
		words.insert("GHI");

		words.traverseForward();

	}
}
