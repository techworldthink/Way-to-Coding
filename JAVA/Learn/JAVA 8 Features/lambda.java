import my_packages.A;

public class lambda{

	public static void main(String[] args) {

		// B c = new B();
		// c.myMethod();

		A a = () -> System.out.println("Lambda example");
		a.myMethod();
	}

}
