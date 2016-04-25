
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Channel.*;

public class MotionDetectorAplication {

	public static void main(String[] args) {
		ImageCapturingDevice imageCapturingDevive = new TestCamera();
		AlarmChannel light = new Light();
		AlarmChannel mail = new Mail();
		AlarmChannel sms = new Sms();

		List<AlarmChannel> alarmChannelList = new ArrayList<AlarmChannel>();
		alarmChannelList.add(light);
		alarmChannelList.add(mail);
		alarmChannelList.add(sms);
		MotionDetector motionDetector = new MotionDetector(imageCapturingDevive, alarmChannelList);
		motionDetector.powerOn();

	}

}
