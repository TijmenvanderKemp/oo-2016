/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise08.Opdracht1;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */
public class Beschrijvingen {

    public static void main ( String [] args ) {
        List<IJsje> ijsjes = new LinkedList<>();
        ijsjes.add(new VanilleIJs());
        ijsjes.add(new Slagroom(new YoghurtIJs()));
        ijsjes.add(new Chocodip(new Slagroom(new Spikkels(new VanilleIJs()))));
        
        for (IJsje ij : ijsjes) {
            System.out.println(ij.geefBeschrijving() + ", kosten: " + ij.prijs());
        }
    }
    
}
