import java.util.logging.Logger;

public class Task implements Runnable {

	private int num;

	public Task(int n) {
		num = n;
	}

	@Override
	public void run() {
		for (int i = 1; i <= num; i++) {
			if (Thread.interrupted()) {
				 System.out.println("I've been interrupted.");
				return;
			}
			System.out.println(i);

		}
	}
}
