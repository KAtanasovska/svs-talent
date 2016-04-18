package Channel;

public class Mail implements AlarmChannel {

	@Override
	public void react() {
		System.out.println("E-mail is sent !");
		
	}

}
