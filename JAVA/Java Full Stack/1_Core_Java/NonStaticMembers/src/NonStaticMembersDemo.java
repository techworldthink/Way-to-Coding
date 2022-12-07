public class NonStaticMembersDemo {

	int num;

	NonStaticMembersDemo() {
		System.out.println("Inside the constructor");
	}

	{
		System.out.println("Inside the non static block");
	}

	public static void main(String[] args) {
		System.out.println("inside the main method");
		NonStaticMembersDemo obj = new NonStaticMembersDemo();

		obj.doSomething();

	}

	static {
		System.out.println("Inside the static block");
	}

	void doSomething() {
		System.out.println("Inside doSomething");
	}

}
