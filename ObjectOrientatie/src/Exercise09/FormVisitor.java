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


public interface FormVisitor<R> {
    R visit( AndForm andForm );
    R visit( FalseForm falseForm );
    R visit( FormulaForm formulaForm );
    R visit( ImpliesForm impliesForm );
    R visit( NotForm notForm );
    R visit( OrForm orForm );
    R visit( TrueForm trueForm );
    
}
