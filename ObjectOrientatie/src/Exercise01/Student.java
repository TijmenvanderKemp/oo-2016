/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise01;

/**
 * A student with a first name, surname and studentnr
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */
public class Student {
    private String voornaam;
    private String achternaam;
    private int studentnr;
    
    /**
     * Default constructor
     * @param voornaam first name of student
     * @param achternaam surname of student
     * @param studentnr studentnr of student
     */
    public Student (String voornaam, String achternaam, int studentnr) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.studentnr = studentnr;
    }
    
    /**
     * standard toString function
     * @return first name + surname + studentnr
     */
    @Override
    public String toString () {
        return voornaam + " " + achternaam + " s" + studentnr;
    }
    
    /**
     * changes name of the studen
     * @param voornaam new first name of the student
     * @param achternaam new surname of the student
     */
    public void setNaam (String voornaam, String achternaam) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
    }
}
