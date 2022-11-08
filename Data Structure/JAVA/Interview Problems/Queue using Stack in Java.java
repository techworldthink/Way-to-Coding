import java.util.Stack;

class Queue {

	private Stack<Integer> enqueueStack;
	private Stack<Integer> dequeueStack;

	public Queue() {
		this.enqueueStack = new Stack<>();
		this.dequeueStack = new Stack<>();
	}

	public void enqueue(int item) {
		this.enqueueStack.push(item);
	}

	public int dequeue() {
		if (enqueueStack.isEmpty() && dequeueStack.isEmpty()) {
			throw new RuntimeException("Stack are empty...");
		}

		if (dequeueStack.isEmpty()) {
			while (!enqueueStack.isEmpty()) {
				dequeueStack.push(enqueueStack.pop());
			}
		}

		return dequeueStack.pop();
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