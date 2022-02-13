package Utility;

public class Random {
    /**
     * Generates a random number between min and max (inclusive)
     * @param min min value of Random
     * @param max max value of random
     * @return random number
     */
    public static int randInt(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
