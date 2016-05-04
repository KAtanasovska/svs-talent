package ACME.thermoregulator;

import com.ventoelectrics.waterheater.VentoHeater;
import com.ventoelectrics.waterheater.VentoPoweredDevice;
import com.ventoelectrics.waterheater.VentoThermometer;

public class EfficientThermoRegulator extends ThermoRegulator {



	public EfficientThermoRegulator(Thermometer ther, Heater heat) {
		thermometer = ther;
		heater = heat;
		sleepSeconds = 1000;
	}

	@Override
	public void setTemperature(Integer tem) {
		super.setTemperature(tem);
	}

	@Override
	public void enablePower(){
		super.enablePower();


	}

	@Override
	public void disablePower() {
		super.disablePower();

	}

	@Override
	public void run(){
		isOn = true;
		while(isOn){
			if (temperature < thermometer.getTemperature()) {
				heater.disable();
			} else {
				heater.enable();
			}
			try {
				wait(sleepSeconds);
				temperature = thermometer.getTemperature();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				break;
			}
		}

	}

}
