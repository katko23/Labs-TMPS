package Flyweight;

import Bridge.Device;
import Bridge.Tv;

import java.util.HashMap;

public class DeviceFactory {
    private static final HashMap tvMap = new HashMap();

    public static Device getTv(int channel) {
        Tv xiaomi = (Tv)tvMap.get(channel);

        if(xiaomi == null) {
            xiaomi = new Tv();
            xiaomi.setChannel(1);
            tvMap.put(channel, xiaomi);
            System.out.println("Creating tv with channel : " + channel);
        }
        return xiaomi;
    }
}
