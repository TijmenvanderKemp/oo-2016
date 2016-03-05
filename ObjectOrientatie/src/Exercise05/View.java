/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise05;

import java.util.Observable;
import java.util.Scanner;

/**
 * Poses questions to the user, gives user input back to the Controller.
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */


public class View {

    private Scanner scanner;
    
    public View () {
        
        scanner = new Scanner (System.in);
        
    }

    public void poseQuestion(Question q) {
        System.out.println(q.toString());
    }
    
    public String giveAnswer() {
        // Give answer to whomever asked.
        return scanner.nextLine();
    }
    
}
