public class LabelledBlock {

	public static void main(String[] args) {

		int x = 20;

		l1: {
			System.out.println("Block Begins");

			if (x == 20) {
				break l1;
			}
			System.out.println("Block Ends");
		}

		System.out.println("Outside the block");

	}

}
