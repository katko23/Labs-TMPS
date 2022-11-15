package Adapter;

public class RoundStand {
    private double area;

    public RoundStand(double area) {
        this.area = area;
    }

    public double getArea() {
        return area;
    }

    public boolean fits(TvStand dev) {
        boolean result;
        result = (this.getArea() >= dev.getArea());
        return result;
    }
}