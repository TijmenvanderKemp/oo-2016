/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise08.Opdracht1;

/**
 * De vanilleijs klasse. Een subklasse van IJsje.
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */
public class VanilleIJs extends IJsje {
    
    public VanilleIJs () {
        beschrijving = "Een vanilleijsje";
    }
    
    @Override
    public int prijs () {
        return 150;
    }

}
