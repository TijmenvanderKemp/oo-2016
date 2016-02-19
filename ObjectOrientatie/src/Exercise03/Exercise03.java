/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise03;

/**
 *
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */
public class Exercise03 {
    
    Galg galg;
    
    public static void main (String[] args) {
        Exercise03 exercise03 = new Exercise03();
    }
    
    public Exercise03 () {
        GalgView galgView = new GalgView();
        galgView.welcome();
        
        String preferredWord = galgView.getWord();
        if (preferredWord.equals("")) {
            galg = new Galg();
        }
        else {
            galg = new Galg(preferredWord);
        }
        
        while (galg.getStatus() == Status.ONGOING) {
            char c = galgView.getLetter();
            if (galg.raadLetter(c)) {
                galgView.rightLetter(galg.getLives(), galg.getCurrentWord());
            }
            else {
                galgView.wrongLetter(galg.getLives(), galg.getCurrentWord());
            }
        }
        
        if (galg.getStatus() == Status.WON){
            galgView.won(galg.getToGuessWord());
        }
            
        if (galg.getStatus() == Status.HANGED){
            galgView.lost(galg.getToGuessWord());
        }
    }
    
}
