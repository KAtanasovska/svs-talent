import java.util.Scanner;

public class TestCamera implements ImageCapturingDevice {
	private Scanner scanner;

	public TestCamera() {
		scanner = new Scanner(System.in);
	}

	public Image getImage() {

		Image img = new Image(scanner.nextLine());

		return img;

	}

	public void turnOffTestCamera() {
		scanner.close();
		System.out.println("The scanning is off");
	}
}
