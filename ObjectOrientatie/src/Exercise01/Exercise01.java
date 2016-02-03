/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise01;

/**
 *
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */
public class Exercise01 {
    
    public static void main (String[] args) {
        
        Student bob = new Student ("Bob", "Janssen", 4567890);
        System.out.println(bob);
        bob.setNaam("Bob", "de Bouwer"); 
        System.out.println(bob);
        
        Groep g = new Groep (2);
        for (int i = 0; i < 3; i ++) {
            System.out.println(g.voegToe(bob));
        }
    }
}
