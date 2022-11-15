package Decorator;

import Bridge.Device;

public abstract class DeviceDecorator implements Device{
    protected Device device;

    public DeviceDecorator(Device device){
        this.device = device;
    }

    public void setRedColor() {
    }
}
