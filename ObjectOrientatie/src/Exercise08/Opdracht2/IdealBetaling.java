/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise08.Opdracht2;

/**
 * Een betaling met ideal
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */


public class IdealBetaling implements Betalingsstrategie{
    private final String bank; //bank waar je de rekening hebt
    private final int rekeningnummer; //rekeningnummer van de rekening
    private final int pincode; //pincode van de rekening
    
    /**
     * constructor voor een idealrekening
     * @param b bank
     * @param rn rekeningnummer
     * @param p pincode
     */
    public IdealBetaling(String b, int rn, int p){
        bank = b;
        rekeningnummer = rn;
        pincode = p;
    }       
    
    /**
     * functie om een betaling met ideal af te ronden
     * @param amount het bedrag dat je wil betalen
     * @return of de betaling gelukt is
     */
    @Override
    public boolean betaal(double amount){
        System.out.format("Pay %1.2f with card %d from bank %s\n", amount, rekeningnummer, bank);
        return true;
    }
}
