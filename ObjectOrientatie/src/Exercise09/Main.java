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
        
        Form expr1 = new OrForm(new TrueForm(), new OrForm(new TrueForm(), new TrueForm()));
        Form expr2 = new ImpliesForm(new NotForm(new FalseForm()), new FalseForm());
        Form expr3 = new AndForm(new FalseForm(), new OrForm(new TrueForm(), new TrueForm()));
        
        PrintFormVisitor pfv1 = new PrintFormVisitor();
        PrintFormVisitor pfv2 = new PrintFormVisitor();
        PrintFormVisitor pfv3 = new PrintFormVisitor();
        
        System.out.println(expr1.accept(pfv1));
        System.out.println(expr2.accept(pfv2));
        System.out.println(expr3.accept(pfv3));
        
        EvalFormVisitor efv1 = new EvalFormVisitor();
        EvalFormVisitor efv2 = new EvalFormVisitor();
        EvalFormVisitor efv3 = new EvalFormVisitor();
        
        System.out.println(expr1.accept(efv1));
        System.out.println(expr2.accept(efv2));
        System.out.println(expr3.accept(efv3));
        
    }
    
}
