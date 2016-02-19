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
    private String toGuessWord;
    private int lives = 11;
    
    public Galg () {
        WoordLezer w = new WoordLezer ("woorden.txt");
        toGuessWord = w.geefWoord();
        for (int i = 0; i < toGuessWord.length(); i ++) {
            currentWord.append(".");
        }
    }
    
    public Galg (String s) {
        toGuessWord = s;
        for (int i = 0; i < toGuessWord.length(); i ++) {
            currentWord.append(".");
        }
    }
    
    public Status getStatus () { // returns in what stage of the game it is
        if (currentWord.equals(toGuessWord)) {
            return Status.WON;
        }
        if (lives == 0) {
            return Status.HANGED;
        }
        return Status.ONGOING;
    }
    
    public boolean raadLetter (char c) { // returns whether the letter was correct or not
                                         // and edits the current StringBuilder
        if (currentWord.indexOf(String.valueOf(c)) >= 0) { // letter is already guessed
            return true;
        }
        else if (!toGuessWord.contains(String.valueOf(c))) { // letter is wrong
            lives -= 1;
            return false;
        }
        else { // letter is guessed correctly
            for (int i = 0; i < toGuessWord.length(); i ++) { // replace all dots with correct letters
                if (toGuessWord.charAt(i) == c) {
                    currentWord.setCharAt(i, c);
                }
            }
            return true;
        }
    }
    
    public int getLives () {
        return lives;
    }
    
    public StringBuilder getCurrentWord () {
        return currentWord;
    }
}
