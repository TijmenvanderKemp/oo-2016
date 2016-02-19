/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise03;

/**
 *
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */
public class Exercise03 {
    
    public static void main (String[] args) {
        Exercise03 exercise03 = new Exercise03();
    }
    
    public Exercise03 () {
        GalgView gv = new GalgView();
        gv.welcome();
        
        String preferredWord = gv.getWord();
        if (preferredWord.equals("")) {
            Galg g = new Galg();
        }
        else {
            Galg g = new Galg(preferredWord);
        }
        
        
    }
    
}
