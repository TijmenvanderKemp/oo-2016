/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise08.Opdracht2;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */
public class Winkelwagen {
    List<Artikel> winkelwagen = new LinkedList<>();
    
    public void voegToe(Artikel a){
        winkelwagen.add(a);
    }
    
    public void verwijder(Artikel a){
        for(int i = 0; i < winkelwagen.size(); i ++){
            if(winkelwagen.get(i).getClass() == a.getClass()){
                winkelwagen.remove(i);
            }    
        }
    }
    
    public double totaalPrijs(){
        double totaal = 0;
        for(Artikel a : winkelwagen)
            totaal += a.getPrijs();
        return totaal;
    }
   

}
