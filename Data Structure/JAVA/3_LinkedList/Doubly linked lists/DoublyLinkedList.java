
public class DoublyLinkedList<T extends Comparable<T>> {

	private Node<T> head;
	private Node<T> tail;

	public void insert(T data) {

		Node<T> newNode = new Node<>(data);

		// first node
		if (tail == null) {
			tail = newNode;
			head = newNode;
		} else {
			newNode.setPreviousNode(tail);
			tail.setNextNode(newNode);
			tail = newNode;
		}
	}

	public void traverseForward() {

		Node<T> actualNode = head;
		while (actualNode != null) {
			System.out.print(actualNode.getData()+"\t");
			actualNode = actualNode.getNextNode();
		}

	}
}
