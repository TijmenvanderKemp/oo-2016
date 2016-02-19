/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise03;

import java.util.Scanner;

/**
 *
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */
public class GalgView {
    
    private Scanner s = new Scanner (System.in);
    
    public GalgView () {
        String preferredWord = getWord();
        if (preferredWord.equals("")) {
            Galg g = new Galg();
        }
        else {
            Galg g = new Galg(preferredWord);
        }
    }
    
    public void welcome() {
        System.out.println("Welcome to Hangman!\n\n");
    }
    
    public String getWord () {
        System.out.println("Please enter a word to guess. Leave empty for a random word.\n");
        return s.nextLine();
    }
    
}
