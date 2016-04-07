 
package Exercise08.Opdracht2;

/**
 *
 * @author Joep
 */


public class IdealBetaling implements Betalingsstrategie{
    private String bank, rekeningnummer;
    private int pincode;
    
    public IdealBetaling(String b, String rn, int p){
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
