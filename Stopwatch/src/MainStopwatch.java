import java.util.Scanner;

public class MainStopwatch {

	public static void main(String[] args) {
		Stopwatch stopwatch = new Stopwatch();
		int command;
		System.out.println("Press 1 to start, 2 stop, 3 pause, 4 resume");
		Scanner scanner = new Scanner(System.in);
		while (true) {
			command = scanner.nextInt();
			switch(command){
			case 1:
				stopwatch.start();
				break;
			case 2:
				stopwatch.stop();
				break;
			case 3:
				stopwatch.pause();
				break;	
			case 4:
				stopwatch.resume();
				break;
			
			
			
			
			}
		}
	}

}
