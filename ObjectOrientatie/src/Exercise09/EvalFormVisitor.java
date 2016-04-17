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
    public Form visit(AndForm andForm) {
        boolean leftValue = (andForm.getLeft().accept(this).getClass() == TrueForm.class);
        boolean rightValue = (andForm.getRight().accept(this).getClass() == TrueForm.class);
        return (leftValue && rightValue ? new TrueForm() : new FalseForm ());
    }

    @Override
    public Form visit(FalseForm falseForm) {
        return "False";
    }

    @Override
    public Form visit(FormulaForm formulaForm) {
        return formulaForm.Formula;
    }

    @Override
    public Form visit(ImpliesForm impliesForm) {
        Form leftOperand = impliesForm.getLeft();
        Form rightOperand = impliesForm.getRight();
        return
    }

    @Override
    public Form visit(NotForm notForm) {
        Form Operand = notForm.getOperand();
        return
    }

    @Override
    public Form visit(OrForm orForm) {
        Form leftOperand = orForm.getLeft();
        Form rightOperand = orForm.getRight();
        return
    }

    @Override
    public Form visit(TrueForm trueForm) {
        return "True";
    }
    
}
