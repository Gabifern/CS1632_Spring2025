package edu.pitt.cs;
import java.util.Random;

public class Passenger {
    private Random rand = new Random();

    public boolean isGettingOff() {
        return rand.nextInt(100) < 10;
    }
}
