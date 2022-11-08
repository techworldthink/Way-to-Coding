
import java.util.Stack;

public class Algorithm {

	private Stack<String> operationStack;
	private Stack<Double> valueStack;

	public Algorithm() {
		this.operationStack = new Stack<>();
		this.valueStack = new Stack<>();
	}

	public void interpretExpression(String expression) {

		String[] expressionArray = expression.split(" ");

		for (String s : expressionArray) {

			if (s.equals("(")) {
				// do nothing !!!
			} else if (s.equals("+")) {
				this.operationStack.push(s);
			} else if (s.equals("*")) {
				this.operationStack.push(s);
			} else if (s.equals(")")) {

				String operation = this.operationStack.pop();

				if (operation.equals("+")) {
					this.valueStack.push(this.valueStack.pop() + this.valueStack.pop());
				} else if (operation.equals("*")) {
					this.valueStack.push(this.valueStack.pop() * this.valueStack.pop());
				}
			} else {
				this.valueStack.push(Double.parseDouble(s));
			}
		}
	}

	public void result() {
		System.out.println(this.valueStack.pop());
	}
}
