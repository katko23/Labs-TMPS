package Composite;

import Bridge.Device;
import Bridge.Radio;
import Bridge.Tv;

public class CompositeTest {
    public static void main(String[] args) {
        CompositeDevice appart = new CompositeDevice(
                new Tv(),
                new Radio()
        );

        appart.printStatus();
        appart.setVolume(50);
        appart.printStatus();



    }
}
