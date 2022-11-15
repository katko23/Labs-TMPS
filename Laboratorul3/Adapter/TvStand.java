package Adapter;

public class TvStand {
    private double diagonal;
    private double length;
    private double height;

    public TvStand() {}

    public TvStand(double diagonal, double length, double height) {
        this.diagonal = diagonal;
        this.length = length;
        this.height = height;
    }

    public double getArea() {
        return length*height;
    }
}
