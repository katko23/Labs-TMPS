# Report for labs

### Course: TMPS
### Author: Coseru Catalin

----


## Objectives:

* Make 5 different types of structural design patterns.
* Get familiarized with structural patterns.

## Implementation description
**Adapter**

*Adapter is a structural design pattern that allows objects with incompatible interfaces to collaborate.

You can see, I have 2 specific classes radio stand and TV stand. Both use the round stand class, to be placed on the wall, thus the problem arises, because the round stand was written for the Tv class, and this stand can only hold a device of a certain size, which in the case of the Tv class is given by the ready method written. To check if the radio can be placed on this round stand, we write an adapter and use the dimensions of the radio as the input for the fit verification method from the RoundStand class.
```
public class TvRadioAdapter extends TvStand{
    private RadioStand radio;

    public TvRadioAdapter(RadioStand radio) {
        this.radio = radio;
    }

    @Override
    public double getArea() {
        double result;
        result = (radio.getLength() * radio.getHeight());
        return result;
    }
}
```

**Bridge**
* Bridge is a structural design pattern that lets you split a large class or a set of closely related classes into two separate hierarchies—abstraction and implementation—which can be developed independently of each other.

This example illustrates how the Bridge pattern can help divide the monolithic code of an app that manages devices and their remote controls. The Device classes act as the implementation, whereas the Remotes act as the abstraction.
The base remote control class declares a reference field that links it with a device object. All remotes work with the devices via the general device interface, which lets the same remote support multiple device types.

``` 
public interface Device {
    boolean isEnabled();

    void enable();

    void disable();

    int getVolume();

    void setVolume(int percent);

    int getChannel();

    void setChannel(int channel);

    void printStatus();
}
```

also  all magic is in following piece of code :

``` 
public class AdvancedRemote extends BasicRemote {

    public AdvancedRemote(Device device) {
        super.device = device;
    }

    public void mute() {
        System.out.println("Remote: mute");
        device.setVolume(0);
    }
}
```

and in Basic Remote :

``` 
public class BasicRemote implements Remote {
    protected Device device;

    public BasicRemote() {}

    public BasicRemote(Device device) {
        this.device = device;
    }

    @Override
    public void power() {
        System.out.println("Remote: power toggle");
        if (device.isEnabled()) {
            device.disable();
        } else {
            device.enable();
        }
    }

    @Override
    public void volumeDown() {
        System.out.println("Remote: volume down");
        device.setVolume(device.getVolume() - 10);
    }

    @Override
    public void volumeUp() {
        System.out.println("Remote: volume up");
        device.setVolume(device.getVolume() + 10);
    }

    @Override
    public void channelDown() {
        System.out.println("Remote: channel down");
        device.setChannel(device.getChannel() - 1);
    }

    @Override
    public void channelUp() {
        System.out.println("Remote: channel up");
        device.setChannel(device.getChannel() + 1);
    }
}
```

**Composite**
* COmposite is a structural design pattern that lets you compose objects into tree structures and then work with these structures as if they were individual objects.

As we can see, I have a baseDevice class that implements the Device interface and offers certain devices such as TV and Radio, in order to operate with several devices, I also have the CompositeDevices class, thus hierarchically from composite Devices, I can operate up to concrete objects such as TV and Radio.


```
public class BaseDevice implements Device {
    private boolean on = false;
    private int volume = 30;
    private int channel = 1;

    public BaseDevice(boolean on, int volume, int channel) {
        this.on = on;
        this.volume = volume;
        this.channel = channel;
    }

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        this.on = true;
    }

    @Override
    public void disable() {
        this.on = false;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int percent) {
        this.volume = percent;
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
    }

    @Override
    public void printStatus() {
        System.out.println("------------------------------------");
        System.out.println("| I'm a device.");
        System.out.println("| I'm " + (on ? "enabled" : "disabled"));
        System.out.println("| Current volume is " + volume + "%");
        System.out.println("| Current channel is " + channel);
        System.out.println("------------------------------------\n");
    }
}

```

``` 
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
```

**Decorator**

* Decorator is a structural design pattern that lets you attach new behaviors to objects by placing these objects inside special wrapper objects that contain the behaviors.

Thus I have a TV object, which should be of different colors at the customer's request, so we decided to add a decorator, to offer the possibility to choose the red color as well. So I have a new object, which contains the Tv object, but which also has a new method for choosing the color red.
Decorator to color in red any device like Tv or Radio.:

```
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
```

**Facade**

* Facade is a structural design pattern that provides a simplified (but limited) interface to a complex system of classes, library or framework.

While Facade decreases the overall complexity of the application, it also helps to move unwanted dependencies to one place.
In this example, the Facade simplifies communication with a complex video conversion framework.

The Facade provides a single class with a single method that handles all the complexity of configuring the right classes of the framework and retrieving the result in a correct format.

```
public class VideoConversionFacade {
    public File convertVideo(String fileName, String format) {
        System.out.println("VideoConversionFacade: conversion started.");
        TvVideoFile file = new TvVideoFile(fileName);
        Codec sourceCodec = CodecFactory.extract(file);
        Codec destinationCodec;
        if (format.equals("mp4")) {
            destinationCodec = new MPEG4CompressionCodec();
        } else {
            destinationCodec = new OggCompressionCodec();
        }
        TvVideoFile buffer = BitrateReader.read(file, sourceCodec);
        TvVideoFile intermediateResult = BitrateReader.convert(buffer, destinationCodec);
        File result = (new AudioMixer()).fix(intermediateResult);
        System.out.println("VideoConversionFacade: conversion completed.");
        return result;
    }
}
```

**Flyweight**

* Flyweight is a structural design pattern that allows programs to support vast quantities of objects by keeping their memory consumption low.

The pattern achieves it by sharing parts of object state between multiple objects. In other words, the Flyweight saves RAM by caching the same data used by different objects.

My example is very simple, I just create 20 TVs, with different channels open, so in case I need to offer a TV with the already created channel, I send the given object, I don't create it again, so I get a release of the branch, because clients can watch the same TV, and it is not necessary to "create" new TV-type objects.
```
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
```

**Proxy**

*Proxy is a structural design pattern that lets you provide a substitute or placeholder for another object. A proxy controls access to the original object, allowing you to perform something either before or after the request gets through to the original object.

We are going to create an Stream interface and concrete classes implementing the Stream interface. ProxyStream is a a proxy class to reduce memory footprint of LiveStream object loading.

ProxyTest, our demo class, will use ProxyStream to get a Stream object to load and display as it needs.

In other words, we have a live stream from YouTube, which must be uploaded to the TV, but to upload it we use the loader, thus to use the loader only once, we use the Proxy design, so now when the stream is needed , it will be displayed without loading from the Internet.
```
    private LiveStream liveStream;
    private String liveHost;

    public ProxyStream(String liveHost){
        this.liveHost = liveHost;
    }

    @Override
    public void display() {
        if(liveStream == null){
            liveStream = new LiveStream(liveHost);
        }
        liveStream.display();
    }
```


##Conclusion and some words to add
Also, each design pattern in this laboratory has a special test, through which you can observe in reality how everything works.