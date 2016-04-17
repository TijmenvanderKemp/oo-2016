/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise09;

/**
 * 
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */


public class TrueForm implements Form {
    public void accept( FormVisitor v ) {
        v.visit(this);
    }
    
    public String toString(){
        return "True";
    }
}