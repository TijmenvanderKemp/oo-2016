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


public class ParenthesesCalculator {
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
            if (outerClass == c) {
                return true;
            }
            if (innerClass == c) {
                return false;
            }
        }
        return true;
    }
}
