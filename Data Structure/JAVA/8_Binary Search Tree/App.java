
public class App {

	public static void main(String[] args) {

		BinarySearchTree<Integer> bst = new BinarySearchTree<>();

		bst.insert(10);
		bst.insert(9);
		bst.insert(8);
		bst.insert(11);

		System.out.println("MAX :: " + bst.getMax());
		System.out.println("MIN :: " + bst.getMin());

		bst.inoderTraversal();
		bst.remove(8);
		bst.inoderTraversal();

	}
}
