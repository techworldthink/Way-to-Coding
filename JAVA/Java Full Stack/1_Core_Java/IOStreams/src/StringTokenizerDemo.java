import java.util.StringTokenizer;

public class StringTokenizerDemo {

	public static void main(String[] args) {

		String s = "You,are,the,creator,of,your,destiny";

		StringTokenizer st = new StringTokenizer(s, ",", false);

		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());

		}

	}

}
