/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise04;

import java.util.Scanner;

/**
 *
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */

public enum Direction {
    EAST (0), NORTH(1), WEST(2), SOUTH(3);
    
    public final int direction;
    
    private Direction (int dir) {
        direction = dir;
    }
}
