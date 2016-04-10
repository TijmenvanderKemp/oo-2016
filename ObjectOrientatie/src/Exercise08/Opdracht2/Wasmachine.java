/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise08.Opdracht2;

/**
 * Een wasmachine artikel
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */


public class Wasmachine extends Artikel{
    public Wasmachine(){
        beschrijving = "Een wasmachine";
        prijs = 499;
    }
    
    @Override
    public double verzendKosten(){
        return 30;
    }
}
