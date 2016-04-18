package Channel;

public class Sms implements AlarmChannel {

	@Override
	public void react() {
		System.out.println("SMS is sent to the owner !");
		
	}
}
