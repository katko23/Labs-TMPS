package Decorator;
import Bridge.Device;

public class RedDeviceDecorator extends DeviceDecorator{

    public RedDeviceDecorator(Device decoratedDevice) {
        super(decoratedDevice);
    }

    @Override
    public void setRedColor() {
        setRedBorder(device);
    }

    private void setRedBorder(Device device){
        System.out.println("Border Color: Red");
    }

    @Override
    public boolean isEnabled() {
        return device.isEnabled();
    }

    @Override
    public void enable() {
        device.enable();
    }

    @Override
    public void disable() {
        device.disable();
    }

    @Override
    public int getVolume() {
        return device.getVolume();
    }

    @Override
    public void setVolume(int percent) {
        device.setVolume(percent);
    }

    @Override
    public int getChannel() {
        return device.getChannel();
    }

    @Override
    public void setChannel(int channel) {
        device.setChannel(channel);
    }

    @Override
    public void printStatus() {
        device.printStatus();
        setRedColor();
    }
}
