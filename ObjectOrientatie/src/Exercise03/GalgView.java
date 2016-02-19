/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise03;

import java.util.Scanner;

/**
 * GalgView is the I/O class of the program.
 * We decided to include near to zero logic, because the exercise said 
 * "This class could be replaced by a GUI." so that's why almost all the logic
 * is in Exercise03 and not here.
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */
public class GalgView {
    
    private Scanner s = new Scanner (System.in);
    
    public GalgView () {
        
    }
    
    public void welcome() {
        System.out.println("Welcome to Hangman!\n");
    }
    
    public String getWord () {
        System.out.println("Please enter a word to guess. Leave empty for a random word.");
        return s.nextLine();
    }
    
    /**
     * Asks the user for a letter to guess. If it doesn't get a letter, it repeats.
     * @return the guessed letter
     */
    public char getLetter () { 
        System.out.println("Please enter a letter to guess");
        String letter = s.nextLine();
        if (letter.isEmpty()){
            return getLetter();
        }
        else {
            return letter.charAt(0);
        }
    }
    
    public void printWord (StringBuilder word) {
        System.out.println(word + "\n");
    }
    
    public void printWord (String word) { 
        System.out.println(word + "\n");
    }
    
    public void printLives (int lives) {
        System.out.println("You have " + lives + " lives left.");
    }
    
    public void printWrongLetters (StringBuilder wrongLetters) {
        System.out.println("You guessed these wrong letters: " + wrongLetters + "\n");
    }
    
    public void rightLetter() { // Tells you if you have guessed a right letter
        System.out.println("You guessed a correct letter!");
    }
    
    public void wrongLetter() { // Tells you if you have guessed a wrong letter
        System.out.println("You guessed a wrong letter!");
    }
    
    public void winner() { // Tells you if you won the game
        System.out.println("You have won, you have guessed the word!");
    }
    
    public void loser() { // Tells you if you have lost the game
        System.out.println("You are out of lives, and you have not guessed the word.");
    }
    
    
}
