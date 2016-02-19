/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise03;

/**
 * The galg is the main Model class. It holds the relevant information for the word, the wrong letters, the lives etc.
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */
public class Galg {
    
    private StringBuilder currentWord = new StringBuilder ("");
    private String toGuessWord;
    private StringBuilder wrongLetters = new StringBuilder ("");
    private int lives = 11;
    
    /**
     * Constructor without a word
     */
    public Galg () {
        WoordLezer w = new WoordLezer ("woorden.txt");
        toGuessWord = w.geefWoord();
        for (int i = 0; i < toGuessWord.length(); i ++) {
            currentWord.append(".");
        }
    }
    
    /**
     * Constructor with a word
     * @param s 
     */
    public Galg (String s) {
        toGuessWord = s;
        for (int i = 0; i < toGuessWord.length(); i ++) {
            currentWord.append(".");
        }
    }
    
    /**
     * Indicates whether the game has stopped, and in which way.
     * @return the status of the game.
     */
    public Status getStatus () { // returns in what stage of the game it is
        if (currentWord.indexOf(".") == -1) {
            return Status.WON;
        }
        if (lives == 0) {
            return Status.HANGED;
        }
        return Status.ONGOING;
    }
    
    /**
     * Edits the stringbuilder to replace dots with the guessed letter
     * @param c the guessed letter
     * @return Whether the letter was correct
     */
    public boolean raadLetter (char c) { 
        if (currentWord.indexOf(String.valueOf(c)) >= 0) { // letter is already guessed
            return true;
        }
        else if (!toGuessWord.contains(String.valueOf(c))) { // letter is wrong
            lives -= 1;
            wrongLetters.append(c);
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
    
    public String getToGuessWord () {
        return toGuessWord;
    }
    
    public StringBuilder getWrongLetters () {
        return wrongLetters;
    }
}
