/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise08.Opdracht1;

/**
 *
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */
public class Slagroom extends IJsjesDecoratie {
    
    public Slagroom(IJsje ijsje) {
        super(ijsje);
        beschrijving = ijsje.geefBeschrijving() + " met slagroom";
    }
    
    @Override
    public int prijs () {
        return ijsje.prijs() + 50;
    }
    

}
