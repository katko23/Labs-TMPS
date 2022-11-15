package Adapter;

public class RadioStand {
    private double width;
    private double length;
    private double height;

    public RadioStand(double width, double length, double height) {
        this.width = width;
        this.length = length;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }

    public double getArea() {
        double result;
        result = width * length;
        return result;
    }
}
