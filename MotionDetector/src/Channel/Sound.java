package Channel;

public class Sound implements AlarmChannel {

	@Override
	public void react() {
		System.out.println("The alert sound is on !");
		
	}
}
