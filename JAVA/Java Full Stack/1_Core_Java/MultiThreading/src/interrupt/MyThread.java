package interrupt;

public class MyThread extends Thread {

	@Override
	public void run() {

		try {
			for (int i = 1; i <= 10; i++) {
				System.out.println("I am a lazy thread");
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			System.out.println("Got Interrupted");
		}

	}

}
