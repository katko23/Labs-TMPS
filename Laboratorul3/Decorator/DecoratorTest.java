package Decorator;

import Bridge.Radio;
import Bridge.Tv;
import Composite.CompositeDevice;

public class DecoratorTest {
    public static void main(String[] args) {
        Tv xiaomi = new Tv();
        Radio smallRadio = new Radio();

        DeviceDecorator redXiaomi = new RedDeviceDecorator(xiaomi);
        DeviceDecorator redSmallRadio = new RedDeviceDecorator(smallRadio);

        redXiaomi.printStatus();
        redSmallRadio.printStatus();

    }
}
