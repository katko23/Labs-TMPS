package Adapter;

public class AdapterTest {
    public static void main(String[] args) {
        TvStand xiaomi = new TvStand(17, 2, 0.75);
        RoundStand stand = new RoundStand(5);

        if (stand.fits(xiaomi)) {
            System.out.println("Round stand can hold Tv xioami.");
        }

        RadioStand smallRadio = new RadioStand(2, 0.2, 0.12);
        RadioStand largeRadio = new RadioStand(20, 2, 3);
        // stand.fits(smallRadio); // Won't compile.

        // Adapter solves the problem.
        TvRadioAdapter smallRadioAdapter = new TvRadioAdapter(smallRadio);
        TvRadioAdapter largeRadioAdapter = new TvRadioAdapter(largeRadio);
        if (stand.fits(smallRadioAdapter)) {
            System.out.println(" Small radio can be hold by this stand.");
        }
        if (!stand.fits(largeRadioAdapter)) {
            System.out.println("Big radio , can't be held by this stand !!");
        }
    }
}
