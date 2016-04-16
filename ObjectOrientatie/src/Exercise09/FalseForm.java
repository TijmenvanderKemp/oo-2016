
package Exercise09;

/**
 *
 * @author Joep
 */


public class FalseForm implements Form{
    public void accept( FormVisitor v ) {
        v.visit(this);
    }
    
    public String toString(){
        return "false";
    }
}
