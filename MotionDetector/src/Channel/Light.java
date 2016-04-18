package Channel;

public class Light implements AlarmChannel {

	@Override
	public void react() {
		System.out.println("The red light is on! ");
		
	}

}
