package Proxy;

public class LiveStream implements Stream {

    private String liveHost;

    public LiveStream(String liveHost){
        this.liveHost = liveHost;
        loadFromHostName(liveHost);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + liveHost);
    }

    private void loadFromHostName(String liveHost){
        System.out.println("Loading " + liveHost);
    }
}
