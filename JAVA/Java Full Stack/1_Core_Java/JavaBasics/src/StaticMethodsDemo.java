public class StaticMethodsDemo {

	public static void main(String[] args) {
		System.out.println("Inside main");
		StaticMethodsDemo.method1();
		System.out.println("Back in main");
	}

	static void method1() {
		System.out.println("Inside method1");
		StaticMethodsDemo.method2();
		System.out.println("Back in method1");
	}

	static void method2() {
		System.out.println("Inside method2");
	}

}
