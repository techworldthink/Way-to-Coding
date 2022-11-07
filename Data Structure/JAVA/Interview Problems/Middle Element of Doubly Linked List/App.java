
public class App {

	public static void main(String[] args) {
		DoublyLinkedList<String> words = new DoublyLinkedList<>();
		words.insert("ABC");
		words.insert("DEF");
		words.insert("GHI");

		words.traverseForward();
		
		System.out.println("\n"+words.findMiddleNode());
		words.insert("JKL");
		System.out.println(words.findMiddleNode());
		words.insert("MNO");
		System.out.println(words.findMiddleNode());

	}
}
