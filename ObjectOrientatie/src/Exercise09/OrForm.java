/*
 *  Made by Joep Veldhoven and Tijmen van der Kemp for the Object Oriëntatie class of 2016.
 *  Do not copy or use without permission.
 */

package Exercise09;

/**
 * A formula based on an Or-construction
 * @author Joep Veldhoven (s4456556)
 * @author Tijmen van der Kemp (s4446887)
 */


public class OrForm implements Form{
    private final Form leftOperand;//left operand of the Or
    private final Form rightOperand;//right operand of the Or
    
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

    @Override
    public <R> R accept( FormVisitor<R> v ) {
        return v.visit(this);
    }
    
    @Override
    public String toString(){
        return "";
    }
}
