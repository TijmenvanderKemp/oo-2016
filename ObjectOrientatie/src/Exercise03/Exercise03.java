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
        galgView.printWord(galg.getCurrentWord());
        
        while (galg.getStatus() == Status.ONGOING) {
            char c = galgView.getLetter();
            if (galg.raadLetter(c)) {
                galgView.rightLetter();
                galgView.printLives(galg.getLives());
                galgView.printWrongLetters(galg.getWrongLetters());
                galgView.printWord(galg.getCurrentWord());
            }
            else {
                galgView.wrongLetter();
                galgView.printLives(galg.getLives());
                galgView.printWrongLetters(galg.getWrongLetters());
                galgView.printWord(galg.getCurrentWord());
            }
        }
        
        if (galg.getStatus() == Status.WON){
            galgView.winner();
            galgView.printLives(galg.getLives());
            galgView.printWrongLetters(galg.getWrongLetters());
            galgView.printWord(galg.getToGuessWord());
        }
            
        if (galg.getStatus() == Status.HANGED){
            galgView.loser();
            galgView.printLives(galg.getLives());
            galgView.printWrongLetters(galg.getWrongLetters());
            galgView.printWord(galg.getToGuessWord());
        }
    }
    
}
