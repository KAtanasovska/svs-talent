package AcmeVentoTermoregulatorAdapters;

import ACME.thermoregulator.*;
import com.ventoelectrics.waterheater.VentoHeater;
import com.ventoelectrics.waterheater.VentoThermometer;
import com.ventoelectrics.waterheater.VentoThermoregulator;




public class AcmeVentoAdapterEfficientThermoRegulator implements VentoThermoregulator {
    private VentoThermometer ventoThermometer;
    private VentoHeater ventoHeater;
    private Heater heater;
    private Thermometer thermometer;
    private ThermoRegulator thermoRegulator;

    public AcmeVentoAdapterEfficientThermoRegulator(VentoThermometer ventoThermometer, VentoHeater ventoHeater){

        this.ventoHeater = ventoHeater;
        this.ventoThermometer = ventoThermometer;

        heater = new AcmeVentoAdapterHeater(ventoHeater);
        thermometer = new AcmeVentoAdapterThermometer(ventoThermometer);
        thermoRegulator = new EfficientThermoRegulator(thermometer, heater);
    }


    @Override
    public void setTemperature(Integer temperature) {
        thermoRegulator.setTemperature(temperature);
    }

    @Override
    public void enablePower() {
        thermoRegulator.enablePower();
    }

    @Override
    public void disablePower() {
        thermoRegulator.disablePower();
    }
}
