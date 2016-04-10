/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise08.Opdracht2;

import java.util.LinkedList;
import java.util.List;

/**
 * Een winkelwagen
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */
public class Winkelwagen {
    List<Artikel> winkelwagen = new LinkedList<>(); //lijst van artikelen in de winkelwagen
    Betalingsstrategie strategie = new IdealBetaling("",0,0); //methode om mee te betalen, staat standaard op ideal.
    
    /**
     * voeg een artikel toe aan de winkelwagen
     * @param a het toe te voegen artikel
     */
    public void voegToe(Artikel a){
        winkelwagen.add(a);
    }
    
    /**
     * verwijder een artikel uit de winkelwagen
     * @param a het te verwijderen artikel
     */
    public void verwijder(Artikel a){
        for(int i = 0; i < winkelwagen.size(); i ++){
            if(winkelwagen.get(i).getClass() == a.getClass()){
                winkelwagen.remove(i);
                break;
            }    
        }
    }
    
    /**
     * verander de betalingsstrategie
     * @param b de nieuwe betalingsstrategie
     */
    public void veranderBetalingsstrategie(Betalingsstrategie b){
        strategie = b;
    }
    
    /**
     * bereken de totaalprijs die je moet betalen als je alles uit het winkelwagentje afrekent
     * @return de prijs die je moet betalen.
     */
    public double totaalPrijs(){
        double totaal = 0;
        List<Double> verzendkosten = new LinkedList<>();
            for(Artikel a : winkelwagen){
            totaal += a.getPrijs();
            double vk = a.verzendKosten();
            if(!verzendkosten.contains(vk)){
                verzendkosten.add(vk);
            }
        } 
        for(double vk : verzendkosten)  
            totaal += vk;
        return totaal;
    }
   
    /**
     * betaal alle artikelen uit het winkelwagentje
     * @param prijs de prijs die je moet betalen 
     * @return true als de betaling gelukt is, false als hij mislukt is.
     */
    public boolean betaal(double prijs){
        return strategie.betaal(prijs);
    }
    
}
