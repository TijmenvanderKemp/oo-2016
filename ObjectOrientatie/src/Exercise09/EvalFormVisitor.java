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


public class EvalFormVisitor implements FormVisitor {

    @Override
    public Boolean visit(AndForm andForm) {
        Boolean leftValue = (Boolean) andForm.getLeft().accept(this);
        Boolean rightValue = (Boolean) andForm.getRight().accept(this);
        return leftValue && rightValue;
    }

    @Override
    public Boolean visit(FalseForm falseForm) {
        return false;
    }

    @Override
    public Boolean visit(FormulaForm formulaForm) {
        return null;
    }

    @Override
    public Boolean visit(ImpliesForm impliesForm) {
        Boolean leftValue = (Boolean) impliesForm.getLeft().accept(this);
        Boolean rightValue = (Boolean) impliesForm.getRight().accept(this);
        return !leftValue || rightValue;
    }

    @Override
    public Boolean visit(NotForm notForm) {
        Boolean value = (Boolean) notForm.getOperand().accept(this);
        return !value;
    }

    @Override
    public Boolean visit(OrForm orForm) {
        Boolean leftValue = (Boolean) orForm.getLeft().accept(this);
        Boolean rightValue = (Boolean) orForm.getRight().accept(this);
        return leftValue || rightValue;
    }

    @Override
    public Boolean visit(TrueForm trueForm) {
        return true;
    }
    
}
