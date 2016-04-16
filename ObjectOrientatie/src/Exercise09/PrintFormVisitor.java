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


public class PrintFormVisitor implements FormVisitor {

    private String totalString = "";
    
    public String getTotalString () {
        return totalString;
    }
    
    @Override
    public void visit(AndForm andForm) {
        totalString = andForm.toString();
    }

    @Override
    public void visit(FalseForm falseForm) {
        totalString = falseForm.toString();
    }

    @Override
    public void visit(FormulaForm formulaForm) {
        totalString = formulaForm.toString();
    }

    @Override
    public void visit(ImpliesForm impliesForm) {
        totalString = impliesForm.toString();
    }

    @Override
    public void visit(NotForm notForm) {
        totalString = notForm.toString();
    }

    @Override
    public void visit(OrForm orForm) {
        totalString = orForm.toString();
    }

    @Override
    public void visit(TrueForm trueForm) {
        totalString = trueForm.toString();
    }
    
    
}
