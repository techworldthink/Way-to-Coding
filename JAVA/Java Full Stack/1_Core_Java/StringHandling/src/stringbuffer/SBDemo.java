package stringbuffer;

public class SBDemo {

	public static void main(String[] args) {

		StringBuffer sb = new StringBuffer();
		System.out.println("Initial Capacity: " + sb.capacity());

		sb.append("All the power is with in you.");
		sb.append("You can do anything and everything.");

		System.out.println(sb);

		System.out.println("Current Capacity: " + sb.capacity());

		System.out.println("charAT: " + sb.charAt(10));

		StringBuffer sb1 = new StringBuffer("abcde");
		System.out.println(sb1.reverse());

		System.out.println(sb1.insert(3, "xyz"));
		System.out.println(sb1.delete(3, 6));
	}

}
