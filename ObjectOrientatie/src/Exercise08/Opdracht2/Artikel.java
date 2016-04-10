/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise08.Opdracht2;

/**
 * Een artikel
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */


public abstract class Artikel {
    protected String beschrijving; //beschrijving van het artikel
    protected double prijs; //prijs van het artikel
    
    public double getPrijs(){
        return prijs;
    }
    
    /**
     * geeft de verzendkosten van een product
     * @return de verzendkosten
     */
    public abstract double verzendKosten();
}
