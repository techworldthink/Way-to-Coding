package interrupt;

public class InterruptDemo {

	public static void main(String[] args) {
		MyThread t = new MyThread();
		t.start();

		//t.interrupt();

		System.out.println("End of the main method");

	}

}
