/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise04;

import java.util.Scanner;

/**
 * The View part of the program.
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
        TekenLoipe tl; // The drawing interface
        
        // First print the picture with AsciiArt
        System.out.println("Stepping through the Loipe. Type 'stop' to stop.");
        tl = new AsciiArt (l);
        tl.teken();
        
        // Loop through it until the user types 'stop'
        while (!"stop".equals(s.nextLine())) {
            tl.setPosition(l.stap());
            tl.teken();
        }
        
        // Then display with the fancy drawing class
        tl = new LoipePlaatje (l);
        tl.teken();
    }
    
}
