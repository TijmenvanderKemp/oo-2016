/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */
package Exercise02;

/**
 * An enumerate of all possible moves and their corresponding coordinate changes.
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */
public enum Move {
    // If this class keeps giving an error, rename it to Move.java instead of move.java
    // It keeps reverting it, and we can't seem to fix it.
    NNE (-2, 1), 
    ENE (-1, 2), 
    ESE (1, 2), 
    SSE (2, 1), 
    SSW (2, -1), 
    WSW (1, -2), 
    WNW (-1, -2), 
    NNW (-2, -1);
    
    public final int y;
    public final int x;
    
    Move (int y, int x) {
        this.y = y;
        this.x = x;
    }
    
}
