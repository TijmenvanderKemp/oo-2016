
package Exercies09;

/**
 *
 * @author Joep
 */


public class OrForm implements Form{
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
        return leftOperand.toString() + "∨" + rightOperand.toString();
    }
}
