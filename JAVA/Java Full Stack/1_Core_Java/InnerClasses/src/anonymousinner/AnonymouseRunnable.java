package anonymousinner;

public class AnonymouseRunnable {

	public static void main(String[] args) {

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Anonymous Runnable Implementation");

			}

		});

		t.start();

	}

}
