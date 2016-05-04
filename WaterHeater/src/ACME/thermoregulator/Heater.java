package ACME.thermoregulator;

/**
 * Created by Kristinata on 5/4/2016.
 */
public interface Heater {
    boolean powerEnabled = false;
    public void enable();
    public void disable();
    public void enablePower();
    public void disablePower();
}
