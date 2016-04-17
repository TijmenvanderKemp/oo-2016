/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise09;

/**
 * Calculates whether parentheses are needed around an operand.
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */


public class ParenthesesCalculator {
    // This is an ordering of classes, from strongest binding to least strong binding.
    private final Class [] classArray = {
        FalseForm.class,
        TrueForm.class,
        FormulaForm.class,
        NotForm.class, 
        AndForm.class, 
        OrForm.class, 
        ImpliesForm.class};
    
    public boolean parenthesesNeeded (Class outerClass, Class innerClass) {
        for (Class c : classArray) {
            // If the outer operator is stronger than the inner, use parentheses
            // If they are equally binding, use them just in case
            if (outerClass == c) {
                return true;
            }
            // If the inner operator is stronger than the outer, don't use parentheses
            if (innerClass == c) {
                return false;
            }
        }
        // When in doubt, parenthesize that shit for maximum clarity
        return true;
    }
}
