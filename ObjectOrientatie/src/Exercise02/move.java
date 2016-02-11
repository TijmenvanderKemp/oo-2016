/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */
package Exercise02;

/**
 *
 * @author Joep
 */
public enum Move {   
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
