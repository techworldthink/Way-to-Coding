import java.util.Stack;

class Queue {

	private Stack<Integer> stack;

	public Queue() {
		this.stack = new Stack<>();
	}

	public void enqueue(int item) {
		this.stack.push(item);
	}

	public int dequeue() {

		// base case for the recursive method calls the first item
		// is what we are after (this is what we need for queue operation)
		if (stack.size() == 1) {
			return stack.pop();
		}

		// we keep poping the items until we find the last one
		int item = stack.pop();

		// we call the method recursively
		int lastDequeuedItem = dequeue();

		// after we find the item we dequeue we have to reinsert the items one by one
		enqueue(item);

		// this is the item we are loooking for (this is what have been popped off in
		// the
		// stack.size()==1 section
		return lastDequeuedItem;

	}

}

class App {
	public static void main(String[] args) {
		Queue obj = new Queue();
		obj.enqueue(0);
		obj.enqueue(1);
		obj.enqueue(2);
		System.out.println(obj.dequeue());
		obj.enqueue(3);
		System.out.println(obj.dequeue());
		obj.enqueue(4);
		System.out.println(obj.dequeue());
		obj.enqueue(5);
		System.out.println(obj.dequeue());
	}
}