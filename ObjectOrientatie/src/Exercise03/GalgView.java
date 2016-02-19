/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise03;

import java.util.Scanner;

/**
 *
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
    
    public char getLetter () { // Returns a letter to guess in Galg
        System.out.println("Please enter a letter to guess");
        String letter = s.nextLine();
        return letter.charAt(0);
    }
    
    public void rightLetter(int lives, StringBuilder currentString) { // Tells you if you have guessed a right letter
        System.out.println("You guessed a correct letter!\nYou have" + lives + "left.\nYou currently have " + currentString);
    }
    
    public void wrongLetter(int lives, StringBuilder currentString) { // Tells you if you have guessed a wrong letter
        System.out.println("You guessed a wrong letter!\nYou have" + lives + "left.\nYou currently have " + currentString);
    }
    
    public void winner(int lives, String toGuessString) { // Tells you if you won the game
        System.out.println("You have won, you have guessed the word and you had" + lives + "left.\nThe word was: " + toGuessString);
    }
    
    public void loser(String toGuessString) { // Tells you if you have lost the game
        System.out.println("You are out of lives, you have not guessed the word.\nThe word was: " + toGuessString);
    }
    
    
}
