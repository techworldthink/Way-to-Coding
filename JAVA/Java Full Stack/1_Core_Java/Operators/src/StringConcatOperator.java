public class StringConcatOperator {

	public static void main(String[] args) {

		String s = "xyz";

		int a = 10, b = 20, c = 30;

		System.out.println(s + a + b + c);
		System.out.println(a + b + c + s);
		System.out.println(a + b + s + c);
		System.out.println(a + s + b + c);

	}

}
