 
package Exercise08.Opdracht2;

/**
 *
 * @author Joep
 */


public class IdealBetaling implements Betalingsstrategie{
    private final String bank;
    private final int rekeningnummer;
    private final int pincode;
    
    public IdealBetaling(String b, int rn, int p){
        bank = b;
        rekeningnummer = rn;
        pincode = p;
    }       
            
    @Override
    public boolean betaal(double amount){
        System.out.format("Pay %1.2f with card %d from bank %s\n", amount, rekeningnummer, bank);
        return true;
    }
}
