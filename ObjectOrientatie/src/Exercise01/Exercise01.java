/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise01;

import java.util.Scanner;

/**
 *
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */
public class Exercise01 {
    
    public static void main (String[] args) {
        Exercise01 exercise01 = new Exercise01 ();
    }
    
    /**
     * Default constructor, handles I/O
     */
    public Exercise01 () {
        
        Scanner scanner = new Scanner (System.in);
        
        System.out.println("Hoe groot moet de groep studenten worden?");
        int aantal = scanner.nextInt();
        scanner.nextLine(); // flush because nextInt is annoying
        if (aantal > 0) { // The user wants a list of more than 0 elements.
            Groep g = new Groep (aantal);
            
            for (int i = 0; i < aantal; i ++) {
                System.out.println("Voornaam van student " + String.valueOf(i + 1) + "?");
                String voornaam = scanner.nextLine();
                System.out.println("Achternaam van student " + String.valueOf(i + 1) + "?");
                String achternaam = scanner.nextLine();
                System.out.println("Studentnr van student " + String.valueOf(i + 1) + "?");
                int studentnr = scanner.nextInt();
                scanner.nextLine();
                
                if (studentnr < 0) { // If the studentnr is negative, stop the creation of the list
                    break;
                }
                
                Student s = new Student (voornaam, achternaam, studentnr);
                g.voegToe(s);
            }
            
            while(true) {
                System.out.println(g.toString());
                
                System.out.println("Volgnummer van student?");
                int volgnr = scanner.nextInt();
                scanner.nextLine();
                if (volgnr < 0) { // "If the volgnummer is negative, stop the program"
                    break;
                }
                if (volgnr >= aantal){ // Index will be out of bounds
                    System.out.println("Volgnummer te hoog");
                    
                }
                else{
                    System.out.println("Voornaam van student?");
                    String voornaam = scanner.nextLine();
                    System.out.println("Achternaam van student?");
                    String achternaam = scanner.nextLine();
                    Student s = g.getStudent(volgnr);
                    if (s != null) {
                        s.setNaam(voornaam, achternaam);
                        g.setStudent(volgnr, s);
                    }
                }
            }
        }
        
    }
}
