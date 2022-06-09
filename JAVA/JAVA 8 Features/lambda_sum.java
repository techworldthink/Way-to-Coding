import my_packages.B;

public class lambda{

	public static void main(String[] args) {
		B a = (x,y) -> System.out.println("Sum is : "+(x+y));
		a.myMethod(10,20);
	}

}
