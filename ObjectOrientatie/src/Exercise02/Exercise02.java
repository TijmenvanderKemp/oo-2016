/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise02;

import java.util.Scanner;

/**
 *
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */
public class Exercise02 {
    
    public static void main (String[] args) {
        Exercise02 exercise02 = new Exercise02 ();
    }
    
    public Exercise02 () {
        Board b = new Board(4, 4);
        b.printBoard();
    }
}
