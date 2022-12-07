public class StringMethods {

	public static void main(String[] args) {
		String s = "Hello World";

		System.out.println("Length of the string is:" + s.length());
		System.out.println("indexOf:" + s.indexOf('o'));
		System.out.println("charAt:" + s.charAt(3));

		System.out.println("substring with beginning index:" + s.substring(2));
		System.out.println("substring with begin and end index:" + s.substring(0, 4));

		String[] result = s.split(" ");
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}

		System.out.println("replace:" + s.replace('l', 'k'));
		System.out.println("toUpperCase:" + s.toUpperCase());
		System.out.println("toLowerCase:" + s.toLowerCase());

	}
}
