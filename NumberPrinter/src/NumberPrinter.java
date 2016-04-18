
public class NumberPrinter {

	public static void main(String[] args) throws InterruptedException {
		final Task t = new Task(2000);
		final Thread tt = new Thread(t);
		tt.start();
		Thread.sleep(10);
		tt.interrupt();
	}

}
