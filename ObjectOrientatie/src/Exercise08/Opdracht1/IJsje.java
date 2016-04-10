/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise08.Opdracht1;

/**
 * De belangrijkste klasse in ons project.
 * Heeft als subklassen de verschillende smaken en de Decorator.
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */
public abstract class IJsje {
    
    protected String beschrijving;
    
    public IJsje () {
        beschrijving = "onbekend ijsje";
    }
    
    public String geefBeschrijving () {return beschrijving;}
    public abstract int prijs ();

}
