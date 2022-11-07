public class App {
	public static void main(String[] args) {
		
		Stack<String> stack = new Stack<>();
		
		stack.push("Adam");
		stack.push("Joe");
		
		System.out.println(stack.size());
		
		System.out.println(stack.pop());

		System.out.println(stack.size());
		
	}

}
