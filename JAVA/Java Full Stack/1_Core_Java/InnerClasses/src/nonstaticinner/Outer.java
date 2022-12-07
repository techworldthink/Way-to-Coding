package nonstaticinner;

public class Outer {

	private static int x = 50;
	private int y;

	Outer(int y) {
		this.y = y;
	}

	void f1() {
		System.out.println("Outer Classes non static method");
	}

	class Inner {
		private int y;

		Inner(int y) {
			this.y = y;
		}

		private void f2() {

			System.out.println("Outer Classes X " + Outer.x);
			System.out.println("Outer Classes Y " + Outer.this.y);
			System.out.println("Inner Classes Y " + this.y);
		}
	}

	public static void main(String[] args) {

		Outer outer = new Outer(80);
		outer.f1();

		Outer.Inner inner = outer.new Inner(30);
		inner.f2();
		System.out.println(inner.y);

	}

}
