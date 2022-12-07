public class ThisKeywordDemo {

	int x;

	ThisKeywordDemo() {
		System.out.println(this);
		System.out.println(this.x);
	}

	public static void main(String[] args) {
		new ThisKeywordDemo();
		new ThisKeywordDemo();
	}
}
