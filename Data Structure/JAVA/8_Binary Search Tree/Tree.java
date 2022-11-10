
public interface Tree<T> {

	public void insert(T data);

	public void remove(T data);

	// in-order traversal yields the natural ordering
	public void inoderTraversal();

	public T getMin();

	public T getMax();

}
