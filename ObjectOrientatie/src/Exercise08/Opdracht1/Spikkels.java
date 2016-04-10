/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise08.Opdracht1;

/**
 * De spikkelsklasse. Een subklasse van IJsjesDecoratie.
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */
public class Spikkels extends IJsjesDecoratie {
    
    public Spikkels(IJsje ijsje) {
        super(ijsje);
        beschrijving = ijsje.geefBeschrijving() + " met spikkels";
    }
    
    @Override
    public int prijs () {
        return ijsje.prijs() + 0;
    }
    

}
