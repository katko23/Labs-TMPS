package Flyweight;

import Bridge.Tv;
import Decorator.DeviceDecorator;

public class FlyweightTest {
    private static final int channels[] = { 1 , 10 , 22 , 33, 51 , 80 };
    public static void main(String[] args) {

        for(int i=0; i < 20; ++i) {
            Tv xiaomi = (Tv) DeviceFactory.getTv(getRandomChannel());
            xiaomi.printStatus();
        }
    }
    private static int getRandomChannel() {
        return channels[(int)(Math.random()*channels.length)];
    }

}
