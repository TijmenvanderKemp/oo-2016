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


public class OrForm implements Form{
    private final ParenthesesCalculator pc = new ParenthesesCalculator();
    
    private Form leftOperand;
    private Form rightOperand;
    public OrForm( Form left, Form right ) {
        this.leftOperand = left;
        this.rightOperand = right;
    }

    public Form getLeft(){
        return leftOperand;
    }

    public Form getRight(){
        return rightOperand;
    }

    public void accept( FormVisitor v ) {
        v.visit(this);
    }
    
    public String toString(){
        boolean leftP = pc.parenthesesNeeded(OrForm.class, leftOperand.getClass());
        boolean rightP = pc.parenthesesNeeded(OrForm.class, rightOperand.getClass());
        return    (leftP ? "(" : "")
                + leftOperand.toString()
                + (leftP ? ")" : "")
                + "∨"
                + (rightP ? "(" : "")
                + rightOperand.toString()
                + (rightP ? ")" : "");
    }
}
