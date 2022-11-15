package Adapter;

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

