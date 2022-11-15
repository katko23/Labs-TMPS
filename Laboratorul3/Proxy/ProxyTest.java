package Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        Stream live = new ProxyStream("https://www.youtube.com/watch?v=2zTdsJqp4ss&list=OLAK5uy_npcMNMib4hik03UoI4gJ9TvKf_5M3gAEU&index=27");
        //live will be loaded
        System.out.println("live will be loaded");
        live.display();
        System.out.println("");
        // live will not be loaded from URL
        System.out.println("live will not be loaded from URL cause using Proxy");
        live.display();
    }
}
