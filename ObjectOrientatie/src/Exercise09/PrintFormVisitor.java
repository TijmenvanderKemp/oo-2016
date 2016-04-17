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
    
    private final ParenthesesCalculator pc = new ParenthesesCalculator();
    
    @Override
    public String visit(AndForm andForm) {
        Form leftOperand = andForm.getLeft();
        Form rightOperand = andForm.getRight();
        boolean leftP = pc.parenthesesNeeded(AndForm.class, leftOperand.getClass());
        boolean rightP = pc.parenthesesNeeded(AndForm.class, rightOperand.getClass());
        return    (leftP ? "(" : "")
                + leftOperand.accept(this)
                + (leftP ? ")" : "")
                + "∧"
                + (rightP ? "(" : "")
                + rightOperand.accept(this)
                + (rightP ? ")" : "");
    }

    @Override
    public String visit(FalseForm falseForm) {
        return "False";
    }

    @Override
    public String visit(FormulaForm formulaForm) {
        return formulaForm.Formula;
    }

    @Override
    public String visit(ImpliesForm impliesForm) {
        Form leftOperand = impliesForm.getLeft();
        Form rightOperand = impliesForm.getRight();
        boolean leftP = pc.parenthesesNeeded(ImpliesForm.class, leftOperand.getClass());
        boolean rightP = pc.parenthesesNeeded(ImpliesForm.class, rightOperand.getClass());
        return    (leftP ? "(" : "")
                + leftOperand.accept(this)
                + (leftP ? ")" : "")
                + "⇒"
                + (rightP ? "(" : "")
                + rightOperand.accept(this)
                + (rightP ? ")" : "");
    }

    @Override
    public String visit(NotForm notForm) {
        Form Operand = notForm.getOperand();
        boolean p = pc.parenthesesNeeded(NotForm.class, Operand.getClass());
        return    "¬"
                + (p ? "(" : "")
                + Operand.accept(this)
                + (p ? ")" : "");
    }

    @Override
    public String visit(OrForm orForm) {
        Form leftOperand = orForm.getLeft();
        Form rightOperand = orForm.getRight();
        boolean leftP = pc.parenthesesNeeded(OrForm.class, leftOperand.getClass());
        boolean rightP = pc.parenthesesNeeded(OrForm.class, rightOperand.getClass());
        return    (leftP ? "(" : "")
                + leftOperand.accept(this)
                + (leftP ? ")" : "")
                + "∨"
                + (rightP ? "(" : "")
                + rightOperand.accept(this)
                + (rightP ? ")" : "");
    }

    @Override
    public String visit(TrueForm trueForm) {
        return "True";
    }
    
    
}
