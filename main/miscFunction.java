package main;
import java.util.Random;

public class miscFunction {

    public static int rng(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max +=1) - min) + min;
    }

}
