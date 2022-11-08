import java.util.Stack;

class MaxItemStack {

	private Stack<Integer> mainStack;
	private Stack<Integer> maxStack;

	public MaxItemStack() {
		this.mainStack = new Stack<>();
		this.maxStack = new Stack<>();
	}

	public void push(int item) {

		// push the new item onto the stack
		this.mainStack.push(item);

		// first item is the same in both stacks
		if (mainStack.size() == 1) {
			maxStack.push(item);
			return;
		}

		// if the item is the largest one so far : we insert it onto the stack
		if (item > maxStack.peek()) {
			maxStack.push(item);
		} else {
			maxStack.push(maxStack.peek());
		}
	}

	// when removing an item we remove it from both stacks
	public int pop() {
		maxStack.pop();
		return mainStack.pop();
	}

	// max item is the last item we have inserted into the maxStack
	public int getMaxItem() {
		return maxStack.peek();
	}

}

class App {
	public static void main(String[] args) {
		MaxItemStack obj = new MaxItemStack();
		obj.push(1);
		obj.push(2);
		obj.push(13);
		obj.push(4);
		obj.push(5);
		System.out.println(obj.getMaxItem());
		obj.pop();
		obj.pop();
		obj.pop();
		System.out.println(obj.getMaxItem());
	}
}