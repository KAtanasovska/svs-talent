package ACME.thermoregulator;

import com.ventoelectrics.waterheater.VentoHeater;
import com.ventoelectrics.waterheater.VentoThermometer;
import com.ventoelectrics.waterheater.VentoThermoregulator;

public abstract class ThermoRegulator extends Thread {

	protected int temperature;
	protected int sleepSeconds = 3000;
	protected Thermometer thermometer;
	protected Heater heater;
	protected boolean isOn = false;
	

	
	public void setTemperature(Integer tem) {
		// TODO Auto-generated method stub
		temperature = tem;
	}

	
	public void enablePower(){
		// TODO Auto-generated method stub
		run();
		

	}

	public void disablePower() {
		// TODO Auto-generated method stub
		isOn=false;
		notifyAll();

	}
	
	
}
