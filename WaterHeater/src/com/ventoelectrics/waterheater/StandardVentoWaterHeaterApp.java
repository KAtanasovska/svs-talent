package com.ventoelectrics.waterheater;

import ACME.thermoregulator.StandardThermoRegulator;
import AcmeVentoTermoregulatorAdapters.AcmeVentoAdapterStandardThermoRegulator;

public class StandardVentoWaterHeaterApp {

	public static void main(String[] args) throws Exception {

		final VentoThermometer ventoThermometer = new VentoThermometer();
		final VentoHeater ventoHeater = new VentoHeater();
		final VentoPowerSwitch ventoPowerSwitch = new VentoPowerSwitch();

		final VentoThermoregulator ventoThermoregulator = new AcmeVentoAdapterStandardThermoRegulator(ventoThermometer, ventoHeater);

		
		ventoPowerSwitch.controlPowerFor(ventoHeater);
		ventoPowerSwitch.controlPowerFor(ventoThermometer);
		ventoPowerSwitch.controlPowerFor(ventoThermoregulator);
		

		VentoWaterHeaterApp.run(ventoThermoregulator, ventoPowerSwitch);
	}
}
