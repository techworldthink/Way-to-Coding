package localinner;

public class Outer {

	void f1() {
		System.out.println("Inside Outers f1()");
		class LocalInner {
			void f2() {
				System.out.println("Inside LocalInners f2()");
			}
		}
		LocalInner inner = new LocalInner();
		inner.f2();

	}

	public static void main(String[] args) {

		Outer outer = new Outer();
		outer.f1();

	}

}
