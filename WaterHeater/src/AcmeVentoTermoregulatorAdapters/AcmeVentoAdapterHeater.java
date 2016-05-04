package AcmeVentoTermoregulatorAdapters;

import ACME.thermoregulator.Heater;
import com.ventoelectrics.waterheater.VentoHeater;

/**
 * Created by Kristinata on 5/4/2016.
 */
public class AcmeVentoAdapterHeater implements Heater {

    VentoHeater ventoHeater;

    public AcmeVentoAdapterHeater(VentoHeater ventoHeater){
        this.ventoHeater = ventoHeater;
    }


    @Override
    public void enable() {
        ventoHeater.enable();
    }

    @Override
    public void disable() {
        ventoHeater.disable();
    }

    @Override
    public void enablePower() {
        ventoHeater.enablePower();
    }

    @Override
    public void disablePower() {
        ventoHeater.disablePower();
    }
}
