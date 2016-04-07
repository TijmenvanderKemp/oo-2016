/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise08.Opdracht2;

/**
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */


public abstract class Artikel {
    protected String beschrijving;
    protected double prijs;
    
    public abstract double verzendKosten();
}
