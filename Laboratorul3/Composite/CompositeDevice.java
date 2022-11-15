package Composite;

import Bridge.Device;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompositeDevice extends BaseDevice {
    protected List<Device> children = new ArrayList<>();

    public CompositeDevice(Device... components) {
        super(true, 0, 1);
        add(components);
    }

    public void add(Device component) {
        children.add(component);
    }

    public void add(Device... components) {
        children.addAll(Arrays.asList(components));
    }

    public void remove(Device child) {
        children.remove(child);
    }

    public void remove(Device... components) {
        children.removeAll(Arrays.asList(components));
    }

    public void clear() {
        children.clear();
    }

    @Override
    public boolean isEnabled() {
        if (children.size() == 0) {
            return false;
        }
        boolean x = children.get(0).isEnabled();
        for (Device child : children) {
            if (child.isEnabled() == true) {
                return true;
            }
        }
        return x;
    }

    @Override
    public void enable() {
        for (Device child : children) {
            child.enable();
        }
    }

    @Override
    public void disable() {
        for (Device child : children) {
            child.disable();
        }
    }

    @Override
    public int getVolume() {
        if (children.size() == 0) {
            return 0;
        }
        int x = children.get(0).getVolume();
        for (Device child : children) {
            if (child.getVolume() < x) {
                x = child.getVolume();
            }
        }
        return x;
    }

    @Override
    public void setVolume(int percent) {
        for (Device child : children) {
            child.setVolume(percent);
        }
    }

    @Override
    public int getChannel() {
        if (children.size() == 0) {
            return 0;
        }
        int x = children.get(0).getChannel();
        for (Device child : children) {
            if (child.getChannel() < x) {
                x = child.getChannel();
            }
        }
        return x;
    }

    @Override
    public void setChannel(int channel) {
        for (Device child : children) {
            child.setChannel(channel);
        }
    }

    @Override
    public void printStatus(){
        for (Device child : children) {
            child.printStatus();
        }
    }
}