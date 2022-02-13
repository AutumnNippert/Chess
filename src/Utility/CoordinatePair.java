package Utility;

/**
 * @author Chris Nippert
 * @version 1.0
 */
public class CoordinatePair {
    public int x;
    public int y;

    /**
     * Creates an X Y value pair.
     * @param x x coordinate
     * @param y y coordinate
     */
    public CoordinatePair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "CoordinatePair{" +
                "x: " + x +
                "y: " + y +
                "}";
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof CoordinatePair cp){
            return this.x == (cp.x) && this.y == (cp.y);
        } else
            return false;
    }
}