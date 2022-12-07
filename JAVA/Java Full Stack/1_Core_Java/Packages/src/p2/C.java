package p2;
import p1.A;
import static p1.A.a1;
import p1.p3.E;

public class C {

	public static void main(String[] args) {
		
		a1();
		p1.A aObject = new A();
		aObject.a2();
		
		E eObject = new E();
		eObject.e1();
	}

}
