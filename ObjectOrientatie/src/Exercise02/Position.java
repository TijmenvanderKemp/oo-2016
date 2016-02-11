/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise02;

/**
 * A simple 2d vector of integers
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */
public class Position {
    
    public int y, x;
    
    /**
     * a constructor for the position.
     * @param y y-coordinate
     * @param x x-coordinate
     */
    public Position (int y, int x) {
        this.y = y;
        this.x = x;
    }
    
    @Override
    public String toString () {
        return "(" + String.valueOf(y) + ", " + String.valueOf(x) + ")";
    }
    
}
