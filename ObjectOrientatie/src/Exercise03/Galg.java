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
public class Galg {
    
    private StringBuilder currentWord = new StringBuilder ("");
    
    public Galg () {
        WoordLezer w = new WoordLezer ("woorden.txt");
        String word = w.geefWoord();
        for (int i = 0; i < word.length(); i ++) {
            currentWord.append(".");
        }
    }
    
    public Galg (String s) {
        
    }
    
    public Status getStatus () { // returns in what stage of the game it is
        return Status.ONGOING;
    }
    
    public boolean raadLetter () { // returns whether the letter was correct or not
                                   // and edits the current StringBuilder
        return false;
    }
    
    public StringBuilder getCurrentWord () {
        return currentWord;
    }
}
