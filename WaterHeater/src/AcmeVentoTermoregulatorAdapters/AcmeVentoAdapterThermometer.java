package AcmeVentoTermoregulatorAdapters;

import ACME.thermoregulator.Thermometer;
import com.ventoelectrics.waterheater.VentoThermometer;

/**
 * Created by Kristinata on 5/4/2016.
 */
public class AcmeVentoAdapterThermometer implements Thermometer {

    VentoThermometer ventoThermometer;

    public  AcmeVentoAdapterThermometer(VentoThermometer ventoThermometer){
        this.ventoThermometer = ventoThermometer;
    }


    @Override
    public Integer getTemperature() {
       return ventoThermometer.getTemperature();
    }
}
