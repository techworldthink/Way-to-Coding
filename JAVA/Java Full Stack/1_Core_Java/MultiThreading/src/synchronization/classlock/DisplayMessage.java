package synchronization.classlock;

public class DisplayMessage {

	public synchronized static void sayHello(String name) {
		for (int i = 1; i <= 10; i++) {
			System.out.println("How are you " + name);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
