import java.util.ArrayList;
import java.util.List;

import Channel.AlarmChannel;
import Channel.Sound;

public class MotionDetector {

	private boolean isOn = false;
	ImageCapturingDevice imageCapturingDevice;
	List<AlarmChannel> channelList;

	public MotionDetector(ImageCapturingDevice imageCapturingDevice, List<AlarmChannel> channelList) {
		this.imageCapturingDevice = imageCapturingDevice;
		this.channelList = channelList;
	}

	public void powerOn() {
		isOn = true;
		System.out.println("Motion detector is on");

		Image firstImg = imageCapturingDevice.getImage();

		while (firstImg.getImg().trim() != "") {
			Image temp = imageCapturingDevice.getImage();
			if (!firstImg.equals(temp)) {

				System.out.println("treba da alarmiram");
				for (int i = 0; i < channelList.size(); i++) {
					channelList.get(i).react();
				}

			}
			firstImg = temp;

		}
		System.out.println("izleze od while");
		imageCapturingDevice.turnOff();
	}

}
