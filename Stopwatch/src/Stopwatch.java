
public class Stopwatch implements Runnable {
	private int seconds;
	private boolean running = false;
    private Thread thread;
	public Stopwatch() {
		seconds = 0;
	}

	public void resume() {
		if (!running) {
			
			thread = new Thread(this);
			thread.start();
			running = true;
		}

	}

	public void pause() {
		if (running) {
			
			thread.interrupt();
		}

	}

	public void stop() {

		
		thread.interrupt();
		seconds = 0;
	}

	public void start() {
		if (!running) {
			thread = new Thread(this);
			thread.start();
			running = true;
		}

	}

	@Override
	public void run() {

		while (true) {
			if (Thread.interrupted()) {
				// Logger.log("I've been interrupted.");
				running = false;
				
				return;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				running =  false;
				return;
			}
			System.out.println(seconds);
			seconds++;

		}

	}
}
