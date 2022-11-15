package Proxy;

public class ProxyStream implements Stream{

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
}