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

public class Main {
    
    public static void main ( String [] args ) {
        
        Form expr1 = new AndForm(new TrueForm(), new FalseForm());
        Form expr2 = new ImpliesForm(new NotForm(new FormulaForm("a")), new FormulaForm("b"));
        Form expr3 = new OrForm(new FormulaForm("c"), new AndForm(new TrueForm(), new TrueForm()));
        
    }
    
}
