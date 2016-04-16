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
        Form expr3 = new AndForm(new FormulaForm("c"), new OrForm(new TrueForm(), new TrueForm()));
        
        PrintFormVisitor pfv1 = new PrintFormVisitor();
        PrintFormVisitor pfv2 = new PrintFormVisitor();
        PrintFormVisitor pfv3 = new PrintFormVisitor();
        
        expr1.accept(pfv1);
        expr2.accept(pfv2);
        expr3.accept(pfv3);
        
        System.out.println(pfv1.getTotalString());
        System.out.println(pfv2.getTotalString());
        System.out.println(pfv3.getTotalString());
    }
    
}
