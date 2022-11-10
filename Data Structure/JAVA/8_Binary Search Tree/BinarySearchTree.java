
public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

	private Node<T> root;

	@Override
	public void insert(T data) {
		if (root == null) {
			root = new Node<T>(data, null);
		} else {
			insert(data, root);
		}
	}

	private void insert(T data, Node<T> node) {
		// data < value in the node - Go to LEFT Sub Tree
		if (node.getData().compareTo(data) > 0) {
			if (node.getLeftChild() != null)
				insert(data, node.getLeftChild());
			else
				node.setLeftChild(new Node<>(data, node));
		} else {
			if (node.getRightChild() != null)
				insert(data, node.getRightChild());
			else
				node.setRightChild(new Node<>(data, node));
		}
	}

	@Override
	public void remove(T data) {
		if (root != null)
			remove(root, data);
	}

	private Node<T> remove(Node<T> node, T data) {

		if (node == null)
			return node;

		if (data.compareTo(node.getData()) < 0) {
			node.setLeftChild(remove(node.getLeftChild(), data));
		} else if (data.compareTo(node.getData()) > 0) {
			node.setRightChild(remove(node.getRightChild(), data));
		} else {

			// we have found the node we want to remove !!!
			if (node.getLeftChild() == null && node.getRightChild() == null) {
				System.out.println("\nRemoving a leaf node...");
				return null;
			}

			if (node.getLeftChild() == null) {
				System.out.println("\nRemoving the right child...");
				Node<T> tempNode = node.getRightChild();
				node = null;
				return tempNode;
			} else if (node.getRightChild() == null) {
				System.out.println("\nRemoving the left child...");
				Node<T> tempNode = node.getLeftChild();
				node = null;
				return tempNode;
			}

			// this is the node with two children case !!!
			System.out.println("\nRemoving item with two children...");
			Node<T> tempNode = getPredecessor(node.getLeftChild());

			node.setData(tempNode.getData());
			node.setLeftChild(remove(node.getLeftChild(), tempNode.getData()));

		}

		return node;
	}

	private Node<T> getPredecessor(Node<T> node) {

		if (node.getRightChild() != null)
			return getPredecessor(node.getRightChild());

		System.out.println("\nPredecessor is: " + node);
		return node;
	}

	@Override
	public void inoderTraversal() {
		if (root == null)
			return;
		inoderTraversal(root);
	}

	private void inoderTraversal(Node<T> node) {

		if (node.getLeftChild() != null)
			inoderTraversal(node.getLeftChild());

		System.out.print(node + " - ");

		if (node.getRightChild() != null)
			inoderTraversal(node.getRightChild());

	}

	@Override
	public T getMin() {
		if (root == null)
			return null;
		return getMin(root.getLeftChild());
	}

	private T getMin(Node<T> node) {
		if (node.getLeftChild() != null)
			return getMin(node.getLeftChild());
		return node.getData();
	}

	@Override
	public T getMax() {
		if (root == null)
			return null;
		return getMax(root.getRightChild());
	}

	private T getMax(Node<T> node) {
		if (node.getRightChild() != null)
			return getMax(node.getRightChild());
		return node.getData();
	}

}
