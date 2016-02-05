/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise01;

/**
 * hoi
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */
public class Groep {
    
    private Student [] studenten;
    
    /**
     * Default constructor
     * @param aantal the number of Students in the Groep
     */
    public Groep (int aantal) {
        studenten = new Student [aantal];
    }
    
    public boolean voegToe (Student student) {
        for (int i = 0; i < studenten.length; i ++) {
            if (studenten[i] == null) {
                studenten[i] = student;
                return true;
            }
        }
        return false;
    }
    
    public Student getStudent (int i) {
        if (studenten[i] == null) {
            return null;
        }
        else {
            return studenten[i];
        }
    }
    
    public boolean setStudent (int i, Student s) {
        if (i >= 0 && i < studenten.length) {
            studenten[i] = s;
            return true;
        }
        else {
            return false;
        }
    }
    
    @Override
    public String toString () {
        String result = "";
        for (Student s : studenten) {
            if (s != null) {
                result += s.toString() + "\n";
            }
        }
        return result;
    }
}
