package AcmeVentoTermoregulatorAdapters;

import ACME.thermoregulator.Heater;
import ACME.thermoregulator.StandardThermoRegulator;
import ACME.thermoregulator.ThermoRegulator;
import ACME.thermoregulator.Thermometer;
import com.ventoelectrics.waterheater.VentoHeater;
import com.ventoelectrics.waterheater.VentoThermometer;
import com.ventoelectrics.waterheater.VentoThermoregulator;

/**
 * Created by Kristinata on 5/4/2016.
 */
public class AcmeVentoAdapterStandardThermoRegulator implements VentoThermoregulator {
    private VentoThermometer ventoThermometer;
    private VentoHeater ventoHeater;
    private Heater heater;
    private Thermometer thermometer;
    private ThermoRegulator thermoRegulator;

    public AcmeVentoAdapterStandardThermoRegulator(VentoThermometer ventoThermometer, VentoHeater ventoHeater){

        this.ventoHeater = ventoHeater;
        this.ventoThermometer = ventoThermometer;

        heater = new AcmeVentoAdapterHeater(ventoHeater);
        thermometer = new AcmeVentoAdapterThermometer(ventoThermometer);
        thermoRegulator = new StandardThermoRegulator(thermometer, heater);
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
