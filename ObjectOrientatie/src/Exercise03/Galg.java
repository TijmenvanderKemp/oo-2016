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
public class Galg {
    
    public Galg () {
        WoordLezer w = new WoordLezer ("woorden.txt");
        String word = w.geefWoord();
    }
    
    public Galg (String s) {
        
    }
}
