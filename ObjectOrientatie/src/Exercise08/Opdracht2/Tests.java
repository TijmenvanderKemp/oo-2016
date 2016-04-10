/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise08.Opdracht2;

/**
 *
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */
public class Tests {

    public static void main ( String [] args ) {
        Winkelwagen winkelwagenA = new Winkelwagen();
        winkelwagenA.voegToe(new Watermeloen());
        winkelwagenA.voegToe(new Wijnglazen());
        winkelwagenA.voegToe(new Wasmachine());
        winkelwagenA.verwijder(new Wasmachine());
        winkelwagenA.veranderBetalingsstrategie(new IdealBetaling("BananenBank", 123456789, 1234));
        winkelwagenA.betaal(winkelwagenA.totaalPrijs());
        
        Winkelwagen winkelwagenB = new Winkelwagen();
        winkelwagenB.voegToe(new Wijnglazen());
        winkelwagenB.voegToe(new Wasmachine());
        winkelwagenB.veranderBetalingsstrategie(new IdealBetaling("BananenBank", 987654321, 5555));
        winkelwagenB.betaal(winkelwagenB.totaalPrijs());
    }
    
}