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


public class LoipeView {
    
    public LoipeView () {
        Scanner s = new Scanner (System.in);
        
        System.out.println("Welcome to Loipe!");
        System.out.println("Please enter your input:");
        String loipeInput = s.nextLine();
        
        Loipe l = new Loipe(loipeInput);
        
        AsciiArt aa = new AsciiArt (l);
        aa.teken();
    }
    
}
