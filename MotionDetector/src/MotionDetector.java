import Channel.AlarmChannel;
import Channel.Sound;

public class MotionDetector {

	private boolean isOn = false;

	public MotionDetector() {
		//argumenti
	}

	public void powerOn() {
		isOn = true;
		System.out.println("Motion detector is on");
		TestCamera testCamera = new TestCamera();
		Image firstImg = testCamera.getImage();
		
		while (firstImg.getImg().trim() != "") {
			Image temp = testCamera.getImage();
			if (!firstImg.equals(temp)) {
				Sound soundAlarm = new Sound();					
				System.out.println("treba da alarmiram");
				soundAlarm.react();
			} 
			firstImg = temp;
			
		}
		testCamera.turnOffTestCamera();
	}


}
