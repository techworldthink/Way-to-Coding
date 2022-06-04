import java.util.Random;

public class RandomDemo {

	public static void main(String[] args) {
		Random obj = new Random();

		System.out.println("x : " + obj.nextInt());
		System.out.println("y : " + obj.nextInt());
		System.out.println("z : " + obj.nextInt());
	}

}
